package com.alkemy.disney.auth.controller;

import com.alkemy.disney.auth.dto.AuthenticationRequest;
import com.alkemy.disney.auth.dto.AuthenticationResponse;
import com.alkemy.disney.auth.dto.Message;
import com.alkemy.disney.auth.dto.UserDTO;
import com.alkemy.disney.auth.entity.UserEntity;
import com.alkemy.disney.auth.jwt.JwtProvider;
import com.alkemy.disney.auth.repository.UserRepository;
import com.alkemy.disney.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class UserAuthController {

    @Autowired
    UserRepository userRepository;
     @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    private EmailService emailService;

    //Convert Dto to userEntity
    @PostMapping("/register")
    public ResponseEntity<?> user (@Valid @RequestBody UserDTO user,
                                          BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(new Message("Error fields or Invalid mail"), HttpStatus.BAD_REQUEST);
        }
        if(userRepository.existsUserByUsername(user.getUsername())){
            return new ResponseEntity<>(new Message("Username exits"), HttpStatus.BAD_REQUEST);
        }
        UserEntity newUser = new UserEntity();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser = this.userRepository.save(newUser);
        if(newUser != null){
            emailService.sendWelcomeEmailTo(newUser.getUsername());
        }
        userRepository.save(newUser);
        return new ResponseEntity<>(new Message("Created User"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Message("Invalid fields"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                                authRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        AuthenticationResponse auth = new AuthenticationResponse(jwt);
        return new ResponseEntity<>(auth, HttpStatus.OK);
    }
}