package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private MovieRepository movieRepository;

	public void saveReview(ReviewDTO dto, Long id) {
		Review review = reviewRepository.getOne(id);
		review.setText(dto.getText());
		review.setMovie(dto.getMovieId());
		reviewRepository.save(review);
	}

	public List<ReviewDTO> findByMovie(Long movieId) {
		try {
			Movie movie = movieRepository.getOne(movieId);
			List<Review> list = reviewRepository.findByMovie(movieId);
			return list.stream().map(x -> new ReviewDTO(x)).collect(Collectors.toList());
		} catch (Exception e) {
			throw new ResourceNotFoundException("Id not found: " + movieId);
		}
	}
}
