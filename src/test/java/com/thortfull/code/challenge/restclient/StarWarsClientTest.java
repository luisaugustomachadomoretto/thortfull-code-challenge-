package com.thortfull.code.challenge.restclient;

import com.thortfull.code.challenge.vo.Film;
import com.thortfull.code.challenge.vo.People;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class StarWarsClientTest {
    @Mock
    private RestTemplate restTemplate;

    @Autowired
    private StarWarsClient starWarsClient;


    @Test
    @SneakyThrows
    public void testGetFilmById_Success() {
        String filmId = "1";
        Film expectedFilm = Mockito.mock(Film.class); // Set remaining film data

        Mockito.when(this.restTemplate.getForObject(Mockito.anyString(), Mockito.eq(Film.class), Mockito.anyString()))
                .thenReturn(expectedFilm);

        Film actualFilm = this.starWarsClient.getFilmById(filmId);

        assertNotNull(actualFilm);
        assertEquals("https://swapi.dev/api/films/1/", actualFilm.url()); // Verify URL construction
    }

    @Test
    @SneakyThrows
    public void testGetPeopleById_Success() {
        String peopleId = "1";
        People expectedPeople = Mockito.mock(People.class); // Set remaining film data

        Mockito.when(this.restTemplate.getForObject(Mockito.anyString(), Mockito.eq(People.class), Mockito.anyString()))
                .thenReturn(expectedPeople);

        People peopleById = this.starWarsClient.getPeopleById(peopleId);

        assertNotNull(peopleById);
        assertEquals("https://swapi.dev/api/people/1/", peopleById.url()); // Verify URL construction
    }

}