package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;

@Service
public class DatabaseService {

	@Autowired
	MovieRepository movieRepo;

	@Autowired
	RatingService ratingService;

	public void create(Movie movie) {
			
		 String rating = ratingService.getMovieRating(movie.getTitle());
	        if(rating != null) {
	            movie.setRating(Float.parseFloat(rating));
	        }
	        movieRepo.save(movie);
		}
	  public List<Movie> getAllMovies() {
	        // TODO Auto-generated method stub

	        return movieRepo.findAll();
	    }

	    public Movie getMovieById(Integer id) {
	        return movieRepo.findById(id).get();
	    }

	    public void update(Movie movie, Integer id) {
	        // TODO Auto-generated method stub
	        Movie toBeUpdated = getMovieById(id);
	        toBeUpdated.setTitle(movie.getTitle());
	        toBeUpdated.setRating(movie.getRating());
	        toBeUpdated.setComment(movie.getComment());
	        toBeUpdated.setPriority(movie.getPriority());

	        movieRepo.save(toBeUpdated);
	    }

}	
