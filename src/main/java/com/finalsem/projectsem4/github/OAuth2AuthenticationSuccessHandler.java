package com.finalsem.projectsem4.github;

import com.finalsem.projectsem4.service.UsersService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@Component
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    UsersService usersService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // Xử lý trường hợp đăng nhập thành công
        CustomOauth2User oauth2User = (CustomOauth2User) authentication.getPrincipal();
        String loginName = oauth2User.getLogin();
        log.info("lay thong tin"+loginName);
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
