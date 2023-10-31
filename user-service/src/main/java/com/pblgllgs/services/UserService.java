package com.pblgllgs.services;

import com.pblgllgs.entities.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService {

    public UserVO save(UserVO userVO){
        String userId =  String.valueOf(new Date().getTime());
        userVO.setId(userId);
        userVO.setRole("USER");
        return userVO;
    }
}
