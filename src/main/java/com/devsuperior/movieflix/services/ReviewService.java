package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository repository;
	
	public void saveReview(ReviewDTO dto, Long id ) {
		Review review = repository.getOne(id);
		review.setText(dto.getText());
		review.setMovie(dto.getMovieId());
		repository.save(review); 		
	}

}
