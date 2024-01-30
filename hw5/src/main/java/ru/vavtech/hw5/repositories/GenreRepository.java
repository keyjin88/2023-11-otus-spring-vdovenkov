package ru.vavtech.hw5.repositories;

import ru.vavtech.hw5.models.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepository {
    List<Genre> findAll();

    Optional<Genre> findById(long id);
}
