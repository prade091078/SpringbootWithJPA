package com.prade.JPA.SpringWithJPA.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prade.JPA.SpringWithJPA.Entity.User;
import com.prade.JPA.SpringWithJPA.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public Optional<User> findById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}
		
}