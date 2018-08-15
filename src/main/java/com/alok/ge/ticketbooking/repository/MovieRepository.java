package com.alok.ge.ticketbooking.repository;

import com.alok.ge.ticketbooking.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface MovieRepository extends CrudRepository<Movie, String> {
    Movie findByName(String name);
}
