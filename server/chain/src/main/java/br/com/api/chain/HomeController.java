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
    
}