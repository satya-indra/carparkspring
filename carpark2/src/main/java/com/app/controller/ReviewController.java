package com.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Reviews;
import com.app.service.IReviewService;

@RestController
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	private IReviewService reviewservice;
	
	@PostMapping("/addreview")
	public ResponseEntity<?> addReview(
										@RequestParam(value="user_id") int user_id,
										@RequestParam(value="property") int property_id,
										@RequestParam(value="review") String review,
										@RequestParam(value="rating") int rating,
										@RequestParam(value="reg_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date reg_date
										
										) {
		Reviews r = new Reviews(review, rating, reg_date);
		return new ResponseEntity<Reviews>(reviewservice.addReview(r, user_id, property_id), HttpStatus.OK);
		
	}
	
	@PostMapping("/getreview")
	public ResponseEntity<?> getReview(	@RequestParam(value="user_id") int user_id,
										@RequestParam(value="property") int property_id
										) {
		return new ResponseEntity<Reviews>(reviewservice.getReview(user_id, property_id), HttpStatus.OK);
		
	}
	

}
