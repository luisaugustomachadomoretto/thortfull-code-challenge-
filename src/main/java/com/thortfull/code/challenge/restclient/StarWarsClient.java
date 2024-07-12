package com.thortfull.code.challenge.restclient;

import com.thortfull.code.challenge.vo.Film;
import com.thortfull.code.challenge.vo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StarWarsClient {

    final RestTemplate restTemplate;


    @Autowired
    public StarWarsClient(RestTemplateBuilder restTemplate) {
        this.restTemplate =  restTemplate.rootUri("https://swapi.dev/api/").build();
    }

    public Film getFilmById(String filmId) {
        return this.restTemplate.getForObject("/films/{movieId}", Film.class, filmId);
    }

    public People getPeopleById(String id) {
        return this.restTemplate.getForObject("/people/{id}", People.class, id);
    }
}