package br.com.tiagobnoronha.rocket_api_curso.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.tiagobnoronha.rocket_api_curso.dtos.CourseDTO;
import br.com.tiagobnoronha.rocket_api_curso.dtos.CreateCourseDTO;
import br.com.tiagobnoronha.rocket_api_curso.dtos.UpdateCourseDTO;
import br.com.tiagobnoronha.rocket_api_curso.entities.CourseEntity;
import br.com.tiagobnoronha.rocket_api_curso.exceptions.CourseAlreadyExistsException;
import br.com.tiagobnoronha.rocket_api_curso.exceptions.CourseNotFoundException;
import br.com.tiagobnoronha.rocket_api_curso.repositories.CourseRepository;
import br.com.tiagobnoronha.rocket_api_curso.services.CourseService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;

    @Override
    public CourseDTO create(CreateCourseDTO course) throws CourseAlreadyExistsException {
        if (this.repository.existsByName(course.name())) {
            throw new CourseAlreadyExistsException("Já existe um curso cadastrado com este nome.");
        }

        CourseEntity entity = CourseEntity.builder()
                .name(course.name())
                .category(course.category())
                .active(true)
                .build();

        CourseEntity newEntity = repository.save(entity);

        return new CourseDTO(newEntity);
    }

    @Override
    public CourseDTO retrieve(UUID id) throws CourseNotFoundException {
        CourseEntity entity = repository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Não foi possível encontrar o courso com o id " + id));

        return new CourseDTO(entity);
    }

    @Override
    public List<CourseDTO> retrieve() {
        List<CourseEntity> entities = repository.findAll();

        return entities.stream().map(CourseDTO::new).toList();
    }

    @Override
    public CourseDTO update(UUID id, UpdateCourseDTO course) throws CourseNotFoundException {
        CourseEntity courseEntity = repository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Não foi possível encontrar curso com o id " + id));

        courseEntity.setName(course.name());
        courseEntity.setCategory(course.category());
        courseEntity.setActive(course.active());

        CourseEntity updatedEntity = repository.save(courseEntity);

        return new CourseDTO(updatedEntity);
    }

    @Override
    public CourseDTO setActive(UUID id, Boolean active) throws CourseNotFoundException {
        CourseEntity courseEntity = repository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Não foi possível encontrar curso com o id " + id));

        courseEntity.setActive(active);
        CourseEntity updatedEntity = repository.save(courseEntity);

        return new CourseDTO(updatedEntity);

    }

    @Override
    public void delete(UUID id) throws CourseNotFoundException {
        CourseEntity courseEntity = repository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Não foi possível encontrar curso com o id " + id));

        repository.delete(courseEntity);
    }

}
