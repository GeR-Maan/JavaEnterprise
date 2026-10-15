package ru.german.javaenterprise.homework_28.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private String title;
    private String content;
    private Account author;
    private String imageUrl;
}
