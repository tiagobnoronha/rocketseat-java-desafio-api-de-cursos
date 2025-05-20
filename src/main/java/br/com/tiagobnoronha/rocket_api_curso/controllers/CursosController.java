package br.com.tiagobnoronha.rocket_api_curso.controllers;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.tiagobnoronha.rocket_api_curso.dtos.CourseDTO;
import br.com.tiagobnoronha.rocket_api_curso.dtos.CreateCourseDTO;
import br.com.tiagobnoronha.rocket_api_curso.dtos.UpdateCourseDTO;
import br.com.tiagobnoronha.rocket_api_curso.exceptions.CourseAlreadyExistsException;
import br.com.tiagobnoronha.rocket_api_curso.exceptions.CourseNotFoundException;
import br.com.tiagobnoronha.rocket_api_curso.services.CourseService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cursos/")
@RequiredArgsConstructor
public class CursosController {

    private final CourseService service;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody CreateCourseDTO course) {
        CourseDTO newCourse;

        try {
            newCourse = service.create(course);
        } catch (CourseAlreadyExistsException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

        final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

        return ResponseEntity.created(URI.create(baseUrl+"/cursos/" + newCourse.id())).body(newCourse);

    }

    @GetMapping("/")
    public ResponseEntity<List<CourseDTO>> retrieve() {
        return ResponseEntity.ok(service.retrieve());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> retrieve(@PathVariable UUID id) {
        CourseDTO course;
        try {
            course = service.retrieve(id);
        } catch (CourseNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(course);

    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@PathVariable UUID id, @RequestBody UpdateCourseDTO course) {
        CourseDTO courseResp;
        try {
            courseResp = service.update(id, course);
        } catch (CourseNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.accepted().body(courseResp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        try{
            service.delete(id);
        }catch(CourseNotFoundException ex){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<CourseDTO> patch(@PathVariable UUID id, @RequestParam(defaultValue = "true") Boolean active) {
        CourseDTO course;

        try{
            course = service.setActive(id, active);
        }catch(CourseNotFoundException ex){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.accepted().body(course);

    }
}
