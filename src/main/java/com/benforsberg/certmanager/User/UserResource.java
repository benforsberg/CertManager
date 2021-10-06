package com.benforsberg.certmanager.User;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.benforsberg.certmanager.Cert.Cert;
import com.benforsberg.certmanager.Cert.CertRepository;
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


    @GetMapping("/")
    public String greeting() {
        return "<center><h1>Hello! Welcome to Ben's spring boot application!</h1></center>";
    }
    @GetMapping("/home")
    public String greetingHome() {
        return greeting  + retrieveAllUsers().get(0).getFirstName() +  " " + retrieveAllUsers().get(0).getLastName() + "!";
    }

    @GetMapping("/private")
    public String privateMessage() {
        return "Heyyy you're on a private page!";
    }


    public String printUserCerts(User user){
        return user.getFirstName() + " " + user.getLastName() + "'s certs: " + "\n";
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

//    //Get certs for a user
//    @GetMapping("/users/{id}/certs")
//    public Set<Cert> retrieveUserCerts(@PathVariable long id) {
//        Optional<User> user = userRepository.findById(id);
//        Set<Cert> certs = user.get().getCerts();
//        if (!user.isPresent())
//            throw new UserNotFoundException("id-" + id);
//
//        return certs;
//    }

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
