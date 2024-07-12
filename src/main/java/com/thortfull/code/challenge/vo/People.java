package com.thortfull.code.challenge.vo;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "People")
public record People(
        String name,
        String height,
        String mass,
        String hairColor,
        String skinColor,
        String eyeColor,
        String birthYear,
        String gender,
        String homeworld,
        String[] films,  // String array for films list
        String[] species, // String array for species list (empty in this case)
        String[] vehicles, // String array for vehicles list
        String[] starships, // String array for starships list
        String created,
        String edited,
        String url
) {
}