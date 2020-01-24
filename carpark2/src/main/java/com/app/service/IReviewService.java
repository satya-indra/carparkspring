package com.app.service;

import com.app.pojos.Reviews;

public interface IReviewService {
	
	Reviews addReview(Reviews r, int user_id, int property_id);

	Reviews getReview(int user_id, int property_id);

}
