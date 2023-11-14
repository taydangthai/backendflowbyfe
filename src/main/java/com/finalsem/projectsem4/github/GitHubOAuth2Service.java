package com.finalsem.projectsem4.github;

import com.finalsem.projectsem4.entity.Users;
import com.finalsem.projectsem4.repository.UsersRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Log4j2
@Service
public class GitHubOAuth2Service {
    private final RestTemplate restTemplate;

    @Value("${spring.security.oauth2.client.registration.github.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.github.client-secret}")
    private String clientSecret;

    @Autowired
    private UsersRepository usersRepository;

    private final String GITHUB_API_USER_URL = "https://api.github.com/user";

    public GitHubOAuth2Service(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public OAuth2AccessToken getAccessToken(String code) {
        String tokenUrl = "https://github.com/login/oauth/access_token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(tokenUrl)
                .queryParam("code", code)
                .queryParam("client_id", clientId)
                .queryParam("client_secret", clientSecret);

        HttpEntity<?> request = new HttpEntity<>(headers);

        ResponseEntity<OAuth2AccessToken> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                request,
                OAuth2AccessToken.class
        );

        return response.getBody();
    }

    public GitHubUserInfo getUserInfo(OAuth2AccessToken accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken.getValue());
        HttpEntity<?> entity = new HttpEntity<>(headers);

        // Gọi GitHub API để lấy thông tin người dùng
        String url = GITHUB_API_USER_URL;
        ResponseEntity<GitHubUserInfo> response = restTemplate.exchange(url, HttpMethod.GET, entity, GitHubUserInfo.class);
        GitHubUserInfo userInfo = response.getBody();

        Optional<Users> users = usersRepository.findByUsername(userInfo.getLogin());
        if(!users.isPresent()){
            Users users1 = new Users();
            users1.setUsername(userInfo.getLogin());
            users1.setEmail("email@github.com");
            users1.setPassword("github");
            users1.setAuthProvider("GITHUB");
            usersRepository.save(users1);
        } else {
            log.info("update -------");
        }

        return userInfo;
    }
}
