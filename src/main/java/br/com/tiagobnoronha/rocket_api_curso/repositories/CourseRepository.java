package br.com.tiagobnoronha.rocket_api_curso.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tiagobnoronha.rocket_api_curso.entities.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity,UUID> {

}
