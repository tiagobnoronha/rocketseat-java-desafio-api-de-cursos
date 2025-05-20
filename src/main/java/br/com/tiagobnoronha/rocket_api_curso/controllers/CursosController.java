package br.com.tiagobnoronha.rocket_api_curso.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cursos")
public class CursosController {

    @PostMapping("/")
    public void create() {

    }

    @GetMapping("/")
    public void retrieve() {

    }

    @GetMapping("/:id")
    public void retrieve(UUID id) {

    }

    @PutMapping("/:id")
    public void update(UUID id){

    }

    @DeleteMapping("/:id")
    public void delete(UUID id){

    }

    @PatchMapping("/:id/active")
    public void patch(UUID id){
        
    }
}
