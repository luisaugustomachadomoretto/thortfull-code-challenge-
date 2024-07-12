package com.thortfull.code.challenge.service;

import com.thortfull.code.challenge.restclient.StarWarsClient;
import com.thortfull.code.challenge.vo.Film;
import com.thortfull.code.challenge.vo.People;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilmService {

    final StarWarsClient starWarsClient;

    @Autowired
    public FilmService(StarWarsClient starWarsClient) {
        this.starWarsClient = starWarsClient;
    }

    public Optional<Film> getFilmByID(String filmId) {
        Optional<Film> response;
        try {
            response = Optional.of(this.starWarsClient.getFilmById(filmId));
        } catch (HttpStatusCodeException httpStatusCodeException) {
            return Optional.empty();
        }
        return response;
    }

    public Optional<People> getPeopleByID(String peopleId) {
        Optional<People> response;
        try {
            response = Optional.of(this.starWarsClient.getPeopleById(peopleId));
        } catch (HttpStatusCodeException httpStatusCodeException) {
            return Optional.empty();
        }
        return response;
    }
}
