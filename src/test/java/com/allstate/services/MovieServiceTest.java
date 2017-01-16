package com.allstate.services;

import com.allstate.entities.Movies;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class MovieServiceTest {
    @Autowired
    private MovieService service;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateMovie() throws Exception {
        Movies before = new Movies();
        before.setTitle("The Matrix");
        Movies after = this.service.create(before);
        assertEquals(2, after.getId());
        assertEquals(0, after.getVersion());
        assertEquals("The Matrix", after.getTitle());
    }

    @Test(expected = org.springframework.dao.DataIntegrityViolationException.class)
    public void shouldNotCreateMovieNoTitle() throws Exception {
        Movies before = new Movies();
        Movies after = this.service.create(before);
        assertEquals(2, after.getId());
    }

    @Test
    public void shouldFindMovieById() throws Exception {
        Movies m = this.service.findById(5);
        assertNull(m);
    }

    @Test
    public void shouldFindAll() throws Exception {
        ArrayList<Movies> result = (ArrayList<Movies>)this.service.findAll();
        assertEquals(1, result.size());
    }

    @Test
    public void shouldFindByTitle() throws Exception {
        Movies m = this.service.findByTitle("The Avengers");
        assertNotNull(m);
    }

    @Test
    public void shouldDeleteById() throws Exception {
        Movies before = new Movies();
        before.setTitle("The Matrix");
        Movies after = this.service.create(before);
        this.service.delete(2);
        Movies m = this.service.findById(2);
        assertNull(m);
    }
    @Test
    public  void  shouldUpdateTest() throws Exception{
        Movies before = new Movies();
        before.setTitle("The Matrix");
        Movies after = this.service.create(before);
        Movies m = this.service.updateTitle(after);
        assertEquals("Nirmal", m.getTitle());
    }
}