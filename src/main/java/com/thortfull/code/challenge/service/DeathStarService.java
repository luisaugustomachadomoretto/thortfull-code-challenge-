package com.thortfull.code.challenge.service;

import com.thortfull.code.challenge.restclient.StarWarsClient;
import com.thortfull.code.challenge.vo.Film;
import com.thortfull.code.challenge.vo.People;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeathStarService {

    final StarWarsClient starWarsClient;

    @Autowired
    public DeathStarService(StarWarsClient starWarsClient) {
        this.starWarsClient = starWarsClient;
    }

    public Optional<Film> getFilmByID(String filmId) {
        Optional<Film> response;
        try {
            response = Optional.of(this.starWarsClient.getFilmById(filmId));
        } catch (HttpStatusCodeException httpStatusCodeException) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Film not found"
            );
        }
        return response;
    }

    public Optional<People> getPeopleByID(String peopleId) {
        Optional<People> response;
        try {
            response = Optional.of(this.starWarsClient.getPeopleById(peopleId));
        } catch (HttpStatusCodeException httpStatusCodeException) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "People not found"
            );
        }
        return response;
    }
}
