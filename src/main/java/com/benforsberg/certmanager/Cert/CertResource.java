package com.benforsberg.certmanager.Cert;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CertResource {

    //private List<Cert> CertsList = new ArrayList<Cert>();
    @Autowired
    CertRepository certRepository;

    @GetMapping("/certs")
    public List<Cert> retrieveAllCerts() {
        return certRepository.findAll();
    }


    @GetMapping("/certs/{id}")
    public Cert retrieveCert(@PathVariable long id) {
        Optional<Cert> Cert = certRepository.findById(id);

        if (!Cert.isPresent())
            throw new CertNotFoundException("id-" + id);

        return Cert.get();
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
