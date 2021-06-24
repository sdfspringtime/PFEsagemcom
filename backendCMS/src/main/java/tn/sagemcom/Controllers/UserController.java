package tn.sagemcom.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.sagemcom.Entities.ResourceNotFoundException;
import tn.sagemcom.Entities.User;
import tn.sagemcom.Repositories.UserRepository;
@Component
@RestController 
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")

public class UserController {

	    
	    @Autowired
	     private UserRepository userRepository;
	    
	    @KafkaListener(topics="Kafka_CMS", groupId ="group_id")
	    public String consume(String message) {
	    	System.out.println("message Consumed is:"+message);
	    	return message;}
	    
	    @GetMapping("/users")
	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }
	    @GetMapping("/users/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long UserId)
	        throws ResourceNotFoundException {
	        User user = userRepository.findById(UserId)
	          .orElseThrow(() -> new ResourceNotFoundException("Users not found for this id :: " + UserId));
	        return ResponseEntity.ok().body(user);
	    }

	    @PutMapping("/users/{id}")
	    public ResponseEntity<User> UpdateUser(@PathVariable(value = "id") Long userId,
	         @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
	        User user = userRepository.findById(userId)
	        .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

	        user.setNom(userDetails.getNom());
	        user.setPrenom(userDetails.getPrenom());
	        user.setMail(userDetails.getMail());
	        user.setPassword(userDetails.getPassword());
	        final User updatedUser = userRepository.save(user);
	        return ResponseEntity.ok(updatedUser);
	    }
	    @PostMapping("/users")    
	        public User createUser( @RequestBody User user) {
	        return userRepository.save(user);
	    }
	    @DeleteMapping(value="/users/{id}")
	    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
	         throws ResourceNotFoundException {
	        User user = userRepository.findById(userId)
	       .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

	        userRepository.delete(user);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }

	}


