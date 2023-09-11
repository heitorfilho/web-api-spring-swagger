package dio.web.api.controller;

import dio.web.api.model.Usuario;
import dio.web.api.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller da um direcionamento para uma funcionalidade existente na aplicação
// Evitar regras de negócios no controller

@RestController
@RequestMapping("/users") // Centralizando o prefixo "/users"
@Tag(name = "web-api", description = "Demo project for Spring Boot")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping()
    public List<Usuario>getUsers(){
        return repository.findAll();
    }

    @GetMapping("/{username}")
    public Usuario getOne(@PathVariable("username") String username){
        return repository.findByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUsers(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }

    @PutMapping()
    public void postUsers(@RequestBody Usuario usuario){
        repository.save(usuario);
    }
}
