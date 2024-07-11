package com.thortfull.code.challenge.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@Api
@RestController
@RequestMapping("api/v1")
@Slf4j
public class ChallengeController {


    @GetMapping("/starwars")
    public ResponseEntity<Object> registerStream() {
        return null;
    }

}
