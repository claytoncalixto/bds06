package com.devsuperior.movieflix.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {
	
	@Autowired
	private  MovieService service;
	
//	@GetMapping
//	public ResponseEntity<Page<MovieDTO>> findAll(
//			@RequestParam(value = "id", defaultValue = "0") Long id,
//			@RequestParam(value = "title", defaultValue = "") String title,
//			@RequestParam(value = "subTitle", defaultValue = "") String subTitle,
//			@RequestParam(value = "year", defaultValue = "yyyy") Integer year,
//			@RequestParam(value = "imgURL", defaultValue = "") String imgUrl,
//			@RequestParam(value = "page", defaultValue = "0") Integer page,
//			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
//			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
//			@RequestParam(value = "orderBy", defaultValue = "title") String orderBy
//			) {
//		
//		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
//			
//		Page<MovieDTO> list = service.findAllPaged(id, title.trim(), pageRequest);		
//		return ResponseEntity.ok().body(list);
//	}
	
	@GetMapping
	public ResponseEntity<Page<MovieDTO>> find(
	@RequestParam(value = "genreId", defaultValue = "0") Long genreId, Pageable pageable) {
	Page<MovieDTO> list = service.find(genreId, pageable);
	return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieDTO> findById(@PathVariable Long id){
		MovieDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
//	@GetMapping(value = "/{genre}")
//	public ResponseEntity<MovieDTO> findByGenre(@PathVariable Movie genre){
//		MovieDTO dto = service.findByGenre(genre);
//		return ResponseEntity.ok().body(dto);
//	}
	
//	@GetMapping(value = "/{id}/reviews")
//	public ResponseEntity<MovieDTO> findByReviews(@PathVariable Long id, Review review){
//		MovieDTO dto = service.findByRevews(review.getId());
//		return ResponseEntity.ok().body(dto);
//	}

}
