package com.thortfull.code.challenge.vo;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Schema(name = "Film")
public record Film(
        String title,
        int episodeId,
        String openingCrawl,
        String director,
        String producer,
        LocalDate releaseDate,
        List<String> characters,
        List<String> planets,
        List<String> starships,
        List<String> vehicles,
        List<String> species,
        LocalDateTime created,
        LocalDateTime edited,
        String url) {
}
