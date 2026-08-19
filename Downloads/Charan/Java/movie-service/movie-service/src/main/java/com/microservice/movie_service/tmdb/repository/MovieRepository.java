package com.microservice.movie_service.tmdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.movie_service.tmdb.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

	
}
