package com.benforsberg.certmanager.User;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.benforsberg.certmanager.Cert.Cert;
import com.benforsberg.certmanager.Cert.CertRepository;
import com.benforsberg.certmanager.Cert.CertResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

    public String greeting = "Welcome ";

    @Autowired
    UserRepository userRepository;
    @Autowired
    CertRepository certRepository;


    @GetMapping("/")
    public String greeting() {
        return "<center><h1>Hello! Welcome to Ben's spring boot application!</h1></center>";
    }


    @GetMapping({"/dashboard", "/dashboard/"})
    public String greetingHome() {
        //Track num users and num certs in system.
        int numUsers = userRepository.findAll().size();
        int numCerts = 0;
        for (int i = 0; i < numUsers; i++) {
            numCerts += userRepository.findAll().get(i).getCerts().size();
        }

        String output = "";
        output = "There are currently " + numUsers + " users and " + numCerts + " tracked certifications in the system.";
        return output;
    }

    //Mapp multiple endpoints to one method
    @GetMapping({"/home/{id}", "/dashboard/{id}"})
    public String greetingHomeUser(@PathVariable long id) {
        String output = "";


        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException("No user found with that ID.");
        }
        boolean isAdmin = user.get().getIsAdmin();
        output = "Welcome " + user.get().getFirstName() + " " + user.get().getLastName() + "!" + "\nYou currently have " + user.get().getCerts().size();

        if (user.get().getCerts().size() == 1)
            output = output + " cert saved.";
        else output = output + " certs saved.";

        if (isAdmin)
            output = output + "\nYou are currently logged in as an admin.";
        else output = output + "\nYou are currently logged in as a standard user.";


        return output;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();

    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable long id) {
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent())
            throw new UserNotFoundException("id-" + id);

        return user.get();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable long id) {
        userRepository.deleteById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent())
            return ResponseEntity.notFound().build();

        user.setId(id);
        userRepository.save(user);

        return ResponseEntity.noContent().build();
    }
}
