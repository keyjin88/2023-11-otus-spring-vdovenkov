package ru.vavtech.hw6.repositories;


import ru.vavtech.hw6.models.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    List<Author> findAll();

    Optional<Author> findById(long id);
}
