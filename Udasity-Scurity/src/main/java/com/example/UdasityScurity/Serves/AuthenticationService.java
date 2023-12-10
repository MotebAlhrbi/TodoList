package com.example.UdasityScurity.Serves;

import com.example.UdasityScurity.Mappers.UserMapper;
import com.example.UdasityScurity.Models.User;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthenticationService implements AuthenticationProvider {


    private UserMapper userMapper;
private HashService hashService;

    public AuthenticationService(UserMapper userMapper, HashService hashService) {
        this.userMapper = userMapper;
        this.hashService = hashService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {


        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = userMapper.getUser(userName);


        if(user!= null){

            String encodingSalt = user.getSalt();
            String hashedPassword = hashService.getHashedValue(password , encodingSalt);



            if(user.getFirstName().equals(hashedPassword)){

                return new UsernamePasswordAuthenticationToken(userName , password , new ArrayList<>());
            }



        }

return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
         return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
