package tn.zeros.template.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.zeros.template.controllers.DTO.LoginDTO;
import tn.zeros.template.controllers.DTO.LoginResponseDTO;
import tn.zeros.template.controllers.DTO.LogoutResponseDTO;
import tn.zeros.template.controllers.DTO.RegistrationDTO;
import tn.zeros.template.entities.Adress;
import tn.zeros.template.entities.User;
import tn.zeros.template.exceptions.InvalidCredentialsException;
import tn.zeros.template.services.IServices.ITokenService;
import tn.zeros.template.services.IServices.IUserService;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@Slf4j
public class AuthenticationController {
    private final IUserService userService;
    private final ITokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<Boolean> registerUser(@RequestBody RegistrationDTO body){
        log.info(body.toString());

        Adress adress = new Adress() ;
        if (body.getAdress() != null) {
            Adress a = new Adress(null, body.getAdress().getStreet(), body.getAdress().getHouseNumber(), body.getAdress().getZipCode());
            adress =a ;
        }
        //User user = new User(null, body.getCode(), body.getEmail(), body.getPassword(), body.getFirstName(),
         //       body.getLastName(), body.getPhoneNumber(), body.getMf(), body.getVille(), null, null, adress);

        User user = User.builder().email(body.getEmail()).password(body.getPassword()).code(body.getCode()).phoneNumber(body.getPhoneNumber()).mf(body.getMf()).lastName(body.getLastName()).firstName(body.getFirstName()).ville(body.getVille()).adress(adress).build();

                log.info(user.getPassword());
        User registeredUser = userService.registerUser(user);
        if (registeredUser != null) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO body) {
        try {
            LoginResponseDTO response = userService.login(body.getEmail(), body.getPassword());
            return ResponseEntity.ok(response);
        } catch (InvalidCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong email or password");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }

    @PostMapping("/login-token")
    public ResponseEntity<?> loginToken(@RequestBody String token) {
        try {
            LoginResponseDTO response = userService.login(token);
            return ResponseEntity.ok(response);
        } catch (InvalidCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<LogoutResponseDTO> logout() {
        try {
            userService.logout();
            return ResponseEntity.ok(new LogoutResponseDTO(true, "Logout successful!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new LogoutResponseDTO(false, e.getMessage()));
        }
    }

    @GetMapping("/check-token")
    public ResponseEntity<Boolean> checkToken(@RequestHeader("Authorization") String token) {
        try {
            if (tokenService.isTokenExpired(token.substring(7))) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
            } else {
                return ResponseEntity.ok(true);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }
}
