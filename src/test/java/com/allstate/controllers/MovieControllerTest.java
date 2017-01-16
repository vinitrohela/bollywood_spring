package com.allstate.controllers;

import com.allstate.entities.Movies;
import com.allstate.services.MovieService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.junit.Assert.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieController.class)
public class MovieControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private MovieService service;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateMovie() throws Exception {
        Movies m = new Movies();
        m.setId(3);
        m.setTitle("Ddlj");

//        given(this.service.create(Mockito.any(Movies.class)))
//                .willReturn(m);
        given(this.service.findById(3))
                .willReturn(m);

        MockHttpServletRequestBuilder request = get("/movies/3");
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"title\":\"Ddlj\"}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(3)))
                .andExpect(jsonPath("$.title", is("Ddlj")));
    }
}