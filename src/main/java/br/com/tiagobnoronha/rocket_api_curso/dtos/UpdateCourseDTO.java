package br.com.tiagobnoronha.rocket_api_curso.dtos;

import br.com.tiagobnoronha.rocket_api_curso.enums.Category;

public record UpdateCourseDTO(
        String name,
        Category category,
        Boolean active) {
}