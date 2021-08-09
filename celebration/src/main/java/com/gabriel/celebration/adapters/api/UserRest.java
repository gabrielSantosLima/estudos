package com.gabriel.celebration.adapters.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserRest {

    @GetMapping
    public String fetchAll(){
        return "Enviado ;)";
    }

    @PostMapping
    public String create(){
        return "";
    }

    @DeleteMapping
    public String deleteAll(){
        return "";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") int id){
        return "" + id;
    }

}
