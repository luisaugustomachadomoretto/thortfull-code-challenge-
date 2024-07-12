package com.thortfull.code.challenge.controller;

//import io.swagger.annotations.Api;

import com.thortfull.code.challenge.service.FilmService;
import com.thortfull.code.challenge.vo.Film;
import com.thortfull.code.challenge.vo.People;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping("api/v1")
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeathStarController {

    final FilmService filmService;

    @Autowired
    public DeathStarController(FilmService filmService) {
        this.filmService = filmService;
    }


    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the Movie",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Film.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Invalid movie id",
                    content = @Content
            )}
    )
    @Operation(
            summary = "Get a film from Star wars serie by its id"
    )

    @GetMapping(
            value = "/starwars/film/{filmId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Optional<Film> getMovieByID(
            @NotNull
            @NotEmpty
            @PathVariable(name = "filmId")
            String filmId
    ) {

        log.info("Request for movie ID: {}", filmId);

        final var film = this.filmService.getFilmByID(filmId);

        var status = film.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.FOUND;

        log.info("Response is {} for movie ID: {}", film, filmId);

        return ResponseEntity.status(status).body(film).getBody();
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found someone from Starwars",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Film.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Invalid people id",
                    content = @Content
            )}
    )
    @Operation(
            summary = "Get a Actor from Star wars serie by its id"
    )

    @GetMapping(
            value = "/starwars/people/{peopleId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Optional<People> getPeopleByID(
            @NotNull
            @NotEmpty
            @PathVariable(name = "peopleId")
            String peopleId
    ) {

        log.info("Request for people ID: {}", peopleId);

        final var people = this.filmService.getPeopleByID(peopleId);

        var status = people.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.FOUND;

        log.info("Response is {} for people ID: {}", people, peopleId);

        return ResponseEntity.status(status).body(people).getBody();
    }

}
