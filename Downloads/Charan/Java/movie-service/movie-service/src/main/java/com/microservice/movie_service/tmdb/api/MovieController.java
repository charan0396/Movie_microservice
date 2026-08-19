package com.microservice.movie_service.tmdb.api;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.microservice.movie_service.tmdb.model.Movie;
import com.microservice.movie_service.tmdb.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
    private static final Logger log = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
		Movie movie = movieService.read(id);
		log.info("-------- returned movie with id: "+id);
		return ResponseEntity.ok(movie);
	}
	
	@PostMapping
	public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
		Movie createdMovie = movieService.create(movie);
		log.info("-------- created movie with id: "+createdMovie.getId());
		return ResponseEntity.ok(createdMovie);
	}
	
	@PutMapping("/{id}")
	public void updateMovie(@PathVariable Long id,@RequestBody Movie movie) {
		movieService.update(id, movie);
		log.info("-------- updated movie with id: "+id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteMovie(@PathVariable Long id) {
		movieService.delete(id);
		log.info("-------- deleted movie with id: "+id);
	}
	
}






