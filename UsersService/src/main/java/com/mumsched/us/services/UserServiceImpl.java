package com.mumsched.us.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mumsched.us.domain.User;
import com.mumsched.us.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {
     @Autowired
	 UserDao userdao;
     
	@Override
	public void createUser(User user) {

      userdao.save(user);
		
	}

	@Override
	public User getUser(Long id) {
		
		return userdao.findOne(id);
	}

	@Override
	public List<User> getAllUsers() {
		
		return userdao.findAll();
	}

	@Override
	public void updateUser(User user) {
		userdao.save(user);
		
	}

	@Override
	public void deleteUser(Long id) {
		userdao.delete(id);
		
	}

	@Override
	public User getUserbyLoginId(String id) {
		// TODO Auto-generated method stub
		return userdao.findByLoginId(id);
	}

	@Override
	public User login(String loginId, String password) {
          
		 
		 User user =userdao.findByLoginId(loginId);
         if(user!=null){
        	 if(user.getPassword().equals(password))
        		 return user;
         }
		return null;
	}

	
}
