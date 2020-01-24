package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Property;
import com.app.pojos.Reviews;
import com.app.pojos.User;
import com.app.repository.PropertyRepository;
import com.app.repository.ReviewRepository;
import com.app.repository.UserRepository;


@Service
@Transactional
public class ReviewServiceImpl implements IReviewService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PropertyRepository propRepo ;
	
	@Autowired
	private ReviewRepository reviewRepo;
	
	@Override
	public Reviews addReview(Reviews r, int user_id, int property_id) {
		User u = userRepo.getOne(user_id);
		Property p = propRepo.getOne(property_id);
		r.setUser(u);
		r.setProperty(p);
		
		return reviewRepo.save(r);
	}

	@Override
	public Reviews getReview(int user_id, int property_id) {
		// TODO Auto-generated method stub
		return reviewRepo.findByUserAndProperty(user_id, property_id);
				
	}

}
