package br.com.tiagobnoronha.rocket_api_curso.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category {

    C_SHARP("C#"),
    DEV_OPS("DevOps"), 
    GO("Go"), 
    AI("IA"), 
    ENGLISH("Inglês"),
    JAVA("Java"), 
    JS("JavaScript"), 
    KOTLIN("Kotlin"),
    LOGIC("Lógica"), 
    NODE_JS("NodeJS"),
    PHP("PHP"), 
    PYTHON("Python"),
    REACT_JS("ReactJS"),
    REACT_NATIVE("React Native"),
    SOFT_SKILLS("Soft Skills"), 
    SWIFT("Swift"), 
    TECH_LEAD("Tech Lead");

    private String description;

}
