package com.prade.JPA.SpringWithJPA.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prade.JPA.SpringWithJPA.Entity.Post;
import com.prade.JPA.SpringWithJPA.Entity.User;
import com.prade.JPA.SpringWithJPA.Exception.UserNotFoundException;
import com.prade.JPA.SpringWithJPA.Repository.PostRepository;
import com.prade.JPA.SpringWithJPA.Repository.UserRepository;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;
    
    @Autowired
    UserRepository userRepository;

    public void addPost(int id,Post post) {
    	Optional<User> userCheck = userRepository.findById(id);
		
		if(!userCheck.isPresent())
			throw new UserNotFoundException("id-"+id);

		User user = userCheck.get();
		
		post.setUser(user);
		
    	postRepository.save(post);
    }
    
    public List<Post> getPostforUser(int id) {
		Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("id"+id);
		}
		
		return user.get().getPosts();
	}
	

	
}