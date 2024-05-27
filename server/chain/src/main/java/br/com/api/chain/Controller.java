package br.com.api.chain;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class Controller {

    //@RequestMapping(value="/", method=RequestMethod.GET)
    @GetMapping("/")
    public String Hello() {
        return "Hello World";
    }
    
}