package ru.vavtech.hw7.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentDto {
    private long id;

    private String comment;

    private long bookId;
}
