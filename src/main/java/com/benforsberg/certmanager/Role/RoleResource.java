package com.benforsberg.certmanager.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class RoleResource {
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/roles")
    public List<Role> retrieveAllRoles() {
        return roleRepository.findAll();
    }

    @GetMapping("/roles/{id}")
    public Role retrieverole(@PathVariable long id) {
        Optional<Role> role = roleRepository.findById(id);

        if (!role.isPresent())
            throw new RoleNotFoundException("id-" + id);

        return role.get();
    }

    @DeleteMapping("/roles/{id}")
    public void deleteRole(@PathVariable long id) {
        roleRepository.deleteById(id);
    }

    @PostMapping("/roles")
    public ResponseEntity<Object> createRole(@RequestBody Role role) {
        Role savedRole = roleRepository.save(role);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedRole.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/roles/{id}")
    public ResponseEntity<Object> updateRole(@RequestBody Role role, @PathVariable long id) {

        Optional<Role> roleOptional = roleRepository.findById(id);

        if (!roleOptional.isPresent())
            return ResponseEntity.notFound().build();

        role.setId(id);

        roleRepository.save(role);

        return ResponseEntity.noContent().build();
    }


}
