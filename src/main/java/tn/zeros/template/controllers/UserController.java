package tn.zeros.template.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.zeros.template.entities.User;
import tn.zeros.template.services.IServices.IUserService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@Slf4j
public class UserController {
    private final IUserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody User user){
        log.info("the user is");
        log.info(String.valueOf(user));
        return ResponseEntity.ok().body(userService.addUser(user));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws IOException {
        userService.removeUser(id);
        return ResponseEntity.ok().body(true);
    }

    @PutMapping("/update")
    public ResponseEntity<?> modify(@RequestBody User user){
        return ResponseEntity.ok().body(userService.modifyUser(user));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(userService.retrieveAllUsers());
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.retrieveUser(id));
    }

}
