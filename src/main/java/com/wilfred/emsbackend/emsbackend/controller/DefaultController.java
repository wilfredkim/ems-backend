package com.wilfred.emsbackend.emsbackend.controller;

import com.wilfred.emsbackend.emsbackend.model.JwtRequest;
import com.wilfred.emsbackend.emsbackend.model.JwtResponse;
import com.wilfred.emsbackend.emsbackend.utility.JwtUtility;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/")
public class DefaultController {
    private UserDetailsService userDetailsService;
    private JwtUtility jwtUtility;

    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
        } catch (BadCredentialsException e) {
            e.printStackTrace();
            throw new Exception("INVALID_CREDENTIALS ", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUsername());

        final String token = jwtUtility.generateToken(userDetails);

        return  new JwtResponse(token);
    }
}
