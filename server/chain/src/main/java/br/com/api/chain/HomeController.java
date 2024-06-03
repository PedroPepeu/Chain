package br.com.api.chain;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
    @GetMapping("/")
    public ClassPathResource Home() {
        return new ClassPathResource("templates/index.html");
    }
    
    @GetMapping("/login")
    public ClassPathResource Login(){
        return new ClassPathResource("templates/login.html");
    }

    @GetMapping("/profile")
    public ClassPathResource Profile(){
        return new ClassPathResource("templates/profile.html");
    }

    @GetMapping("/project")
    public ClassPathResource Project(){
        return new ClassPathResource("templates/projects.html");
    }

    @GetMapping("/cadastro")
    public ClassPathResource Cadastro(){
        return new ClassPathResource("templates/cadastro.html");
    }

    @GetMapping("/404")
    public ClassPathResource e404(){
        return new ClassPathResource("templates/errors/404.html");
    }
}