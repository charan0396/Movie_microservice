package com.microservice.movie_service.tmdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.movie_service.tmdb.model.Movie;
import com.microservice.movie_service.tmdb.repository.MovieRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public Movie create(Movie movie) {
		if (movie == null) {
			throw new RuntimeException("Invalid movie");
		}
		return movieRepository.save(movie);
	}

	public Movie read(Long id) {
		return movieRepository.findById(id).orElseThrow(() -> new RuntimeException("movie not found"));
	}

	public void update(Long id,Movie update) {
		if (update == null || id == null) {
			throw new RuntimeException("Invalid movie");
		}
		
		if (movieRepository.existsById(id)) {
			Movie movie = movieRepository.getReferenceById(id);
			movie.setName(update.getName());
			movie.setDirector(update.getDirector());
			movie.setActros(update.getActros());
			movieRepository.save(movie);
			
		} else {
			throw new RuntimeException("movie not found");
		}
	}

	public void delete(Long id) {

		if (movieRepository.existsById(id)) {
			movieRepository.deleteById(id);
		} else {
			throw new RuntimeException("movie not found");
		}

	}
}
