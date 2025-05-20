package br.com.tiagobnoronha.rocket_api_curso.services;

import java.util.List;
import java.util.UUID;

import br.com.tiagobnoronha.rocket_api_curso.dtos.CourseDTO;
import br.com.tiagobnoronha.rocket_api_curso.dtos.CreateCourseDTO;
import br.com.tiagobnoronha.rocket_api_curso.dtos.UpdateCourseDTO;
import br.com.tiagobnoronha.rocket_api_curso.exceptions.CourseAlreadyExistsException;
import br.com.tiagobnoronha.rocket_api_curso.exceptions.CourseNotFoundException;

public interface CourseService {

    public CourseDTO create(CreateCourseDTO course) throws CourseAlreadyExistsException;

    public CourseDTO retrieve(UUID id) throws CourseNotFoundException;

    public List<CourseDTO> retrieve();

    public CourseDTO update(UUID id, UpdateCourseDTO course) throws CourseNotFoundException;

    public void delete(UUID id) throws CourseNotFoundException;

    public CourseDTO setActive(UUID id, Boolean active) throws CourseNotFoundException;

}
