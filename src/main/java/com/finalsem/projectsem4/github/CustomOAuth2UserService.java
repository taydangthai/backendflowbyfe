package com.finalsem.projectsem4.github;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        /*OAuth2User oAuth2User = super.loadUser(userRequest);
        // Xử lý thông tin người dùng từ oAuth2User
        log.info("User Name: " + oAuth2User.getName());
        log.info("User Attributes: " + oAuth2User.getAttributes());
        return oAuth2User;*/
        log.info("cái gì đây" + userRequest.toString());
        return new CustomOauth2User(super.loadUser(userRequest));
    }
}
