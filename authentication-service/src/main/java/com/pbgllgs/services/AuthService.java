package com.pbgllgs.services;

import com.pbgllgs.entities.AuthRequest;
import com.pbgllgs.entities.AuthResponse;
import com.pbgllgs.entities.UserVO;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {

    private final JwtUtil jwtUtil;
    private final RestTemplate restTemplate;

    public AuthService(JwtUtil jwtUtil, RestTemplate restTemplate) {
        this.jwtUtil = jwtUtil;
        this.restTemplate = restTemplate;
    }

    public AuthResponse register(AuthRequest request) {
        request.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        UserVO registeredUser = restTemplate.postForObject("http://user-service/users", request, UserVO.class);
        String accessToken = jwtUtil.generate(registeredUser.getId(), registeredUser.getRole(), "ACCESS");
        String refreshToken = jwtUtil.generate(registeredUser.getId(), registeredUser.getRole(), "REFRESH");

        return new AuthResponse(accessToken, refreshToken);
    }
}
