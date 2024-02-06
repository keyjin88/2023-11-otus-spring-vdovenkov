package ru.vavtech.hw6.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vavtech.hw6.models.Author;
import ru.vavtech.hw6.repositories.AuthorRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
