package ru.vavtech.hw5.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.vavtech.hw5.models.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JdbcGenreRepository implements GenreRepository {
    private final NamedParameterJdbcOperations namedJdbc;

    @Override
    public List<Genre> findAll() {
        return namedJdbc.query("SELECT id, name FROM genres", new GenreRowMapper());
    }

    @Override
    public Optional<Genre> findById(long id) {
        var genreList = namedJdbc.query(
                "SELECT id, name FROM genres WHERE id = :id", Map.of("id", id), new GenreRowMapper());
        return genreList.isEmpty() ? Optional.empty() : Optional.of(genreList.get(0));
    }

    private static class GenreRowMapper implements RowMapper<Genre> {

        @Override
        public Genre mapRow(ResultSet rs, int i) throws SQLException {
            var id = rs.getLong("id");
            var name = rs.getString("name");
            return new Genre(id, name);
        }
    }
}