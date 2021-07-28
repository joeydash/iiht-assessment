package org.grow90.finmlapi.controller;

import org.grow90.finmlapi.exceptionutility.UserNotFoundException;
import org.grow90.finmlapi.model.user.*;
import org.grow90.finmlapi.service.UserService;
import org.grow90.finmlapi.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "user")
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @PostMapping("authenticate")
    public ResponseEntity<AuthResponse> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        } catch (Exception e) {
            throw new UserNotFoundException("Username or password is incorrect");
        }
        return ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(authRequest.getUserName())));
    }

    @PostMapping("checkUserExist")
    public ResponseEntity<CheckUserExistResponse> checkUserExist(@RequestBody CheckUserExistRequest checkUserExistRequest) throws Exception {
        return ResponseEntity.ok(userService.isUserNameExist(checkUserExistRequest));
    }

    @PostMapping("signUp")
    public SignUpResponse checkUserExist(@RequestBody SignUpRequest signUpRequest) throws Exception {
        System.out.println(signUpRequest);
        return userService.signUp(signUpRequest);
    }

    @GetMapping("verifyMailId/{userId}")
    public String verifyMailId(@PathVariable int userId) throws Exception {
        userService.verifyMailId(userId);
        return "Verified successfully";
    }
}
