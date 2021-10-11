package com.benforsberg.certmanager.Cert;


import com.benforsberg.certmanager.User.User;
import com.benforsberg.certmanager.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

@RestController
public class CertResource {

    @Autowired
    CertRepository certRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/certs")
    public List<Cert> retrieveAllCerts() {
        return certRepository.findAll();
    }

    //Retrieve a specific cert given its ID
    @GetMapping("/certs/{id}")
    public Cert retrieveCert(@PathVariable long id) {
        Optional<Cert> cert = certRepository.findById(id);

        if (!cert.isPresent())
            throw new CertNotFoundException("id-" + id);

        return cert.get();
    }

    //Return a cert given a certcode
    @GetMapping("/lookup/{id}")
    public Cert retrieveCertByCode(@PathVariable String id) {
        List<Cert> certs = certRepository.findByCertCode(id.toUpperCase());
        return certs.get(0);
    }

    //Find the owner of a specific cert
    @GetMapping("/lookupowner/{id}")
    public Long retrieveCertOwnerIDByCode(@PathVariable String id) {
        List<Cert> certs = certRepository.findByCertCode(id);
        Cert cert = certs.get(0);
        Long userID = cert.getOwnerID();
        return userID;
    }

    //Return set of all certs for a given user
    @GetMapping("/users/{id}/certs")
    public Set<Cert> retrieveCertByUserID(@PathVariable long id) {
        System.out.println("Looking for user " + id);
        Optional<User> user = userRepository.findById(id);
        System.out.println("Found user " + user.get().getFirstName() + " " + user.get().getLastName());
        Set<Cert> certs = user.get().getCerts();

        return certs;
    }

    @GetMapping("/certs/{id}/status")
    public boolean retrieveCertExpirationStatus(@PathVariable String id) {
        List<Cert> certs = certRepository.findByCertCode(id);
        Cert cert = certs.get(0);
        boolean isExpired = cert.getIsExpired();
        return isExpired;
    }


    @DeleteMapping("/certs/{id}")
    public void deleteCert(@PathVariable long id) {
        certRepository.deleteById(id);
    }

    @PostMapping("/certs")
    public ResponseEntity<Object> createCert(@RequestBody Cert cert) {
        Cert savedCert = certRepository.save(cert);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedCert.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/certs/{id}")
    public ResponseEntity<Object> updateCert(@RequestBody Cert cert, @PathVariable long id) {

        Optional<Cert> CertOptional = certRepository.findById(id);

        if (!CertOptional.isPresent())
            return ResponseEntity.notFound().build();

        cert.setId(id);

        certRepository.save(cert);

        return ResponseEntity.noContent().build();
    }

}
