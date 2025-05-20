package br.com.tiagobnoronha.rocket_api_curso.dtos;

import java.util.Date;
import java.util.UUID;

import br.com.tiagobnoronha.rocket_api_curso.entities.CourseEntity;

public record CourseDTO(
        UUID id,
        String name,
        String category,
        Boolean active,
        Date createdAt,
        Date updatedAt) {

    public CourseDTO(CourseEntity entity) {
        this(entity.getId(),
                entity.getName(),
                entity.getCategory().getDescription(),
                entity.getActive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt());

    }

}
