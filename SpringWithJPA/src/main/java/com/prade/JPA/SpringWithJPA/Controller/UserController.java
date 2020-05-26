package com.prade.JPA.SpringWithJPA.Controller;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prade.JPA.SpringWithJPA.Entity.Post;
import com.prade.JPA.SpringWithJPA.Entity.User;
import com.prade.JPA.SpringWithJPA.Exception.UserNotFoundException;
import com.prade.JPA.SpringWithJPA.Service.PostService;
import com.prade.JPA.SpringWithJPA.Service.UserService;

@RestController
@RequestMapping({ "v1/" })
public class UserController {

	/*@Autowired //Autowiring feature of spring framework enables you to inject the object dependency implicitly. It internally uses setter or constructor injection. Autowiring can't be used to inject primitive and string values.
	
	/*@PostMapping("user/createNew") // return proper status code created
	public ResponseEntity<Object> createUserAndReturn(@Valid @RequestBody User user) {
		User newuser = repository.save(user);
		
		// get new id and form URI from current servlet
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(newuser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}*/
	
	
	@Autowired
	UserService userService;
	
	@Autowired
	PostService postService;
	
	@PostMapping("user/create") // return proper status code created
	public void createUser(@RequestBody User user) {
		 userService.addUser(user);
	}

	@GetMapping("getalluser")
	public List<User> retrieveAllUsers(){
		return userService.findAll();
	}
	
	@GetMapping("getUser/{id}")
	public Optional<User> getAUser(@PathVariable int id) {
		Optional<User> user = userService.findById(id);
		
		if(!user.isPresent())
			throw new UserNotFoundException("id-"+id);
		
		return user;
	}
	
	@DeleteMapping("deleteuser/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteById(id);
	}
	
	@GetMapping("user/{id}/posts")
	public List<Post> getPostforUser(@PathVariable int id) {
				return postService.getPostforUser(id);
				
	}
	
	@PostMapping("user/{id}/posts")
	public void createPostforUser(@PathVariable int id,@RequestBody Post post) {
				postService.addPost(id,post);
		
	}
}
