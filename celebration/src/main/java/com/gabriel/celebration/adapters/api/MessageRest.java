package com.gabriel.celebration.adapters.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageRest {

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

    @GetMapping("/{id}")
    public String findByuUserId(@PathVariable("id") int id){
        return "" + id;
    }

}
