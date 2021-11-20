package com.devsuperior.movieflix.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.services.ReviewService;

@RestController
@RequestMapping(value = "/reviews" )
public class ReviewResource {
	
	@Autowired
	private ReviewService service;
	
	@PreAuthorize("hasAnyRole('MEMBER')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> saveReview(@PathVariable Long id, @RequestBody ReviewDTO dto) {
		service.saveReview(dto, id);
		return ResponseEntity.noContent().build();
	}
}
