package br.com.tiagobnoronha.rocket_api_curso.exceptions;

public class CourseAlreadyExistsException extends Exception {

    public CourseAlreadyExistsException(String message) {
        super(message);
    }
}
