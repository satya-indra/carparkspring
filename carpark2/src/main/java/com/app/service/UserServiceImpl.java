package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;



import com.app.pojos.User;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User addUser(User u) {
            return userRepo.save(u);
            
	}

	@Override
	public User validateUser(String email, String password) {
		return userRepo.findByEmailAndPassword(email, password);
	}

	@Override
	public List<User> userList() {
		return userRepo.findAll();
	}

	@Override
	public User userDelete(int id) {
		User u = userRepo.getOne(id);
		u.setStatus(null);
		return u;
		
	}
}
