package com.finalsem.projectsem4.github;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Log4j2
@RestController
@CrossOrigin(origins = "*")
public class GithubController {

    @Value("${spring.security.oauth2.client.registration.github.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.github.redirect-uri}")
    private String redirectUri;

    @Value("${spring.security.oauth2.client.registration.github.scope[0]}")
    private String scope1;

    @Value("${spring.security.oauth2.client.registration.github.scope[1]}")
    private String scope2;

    private final String GITHUB_API_USER_URL = "https://api.github.com/user";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GitHubOAuth2Service gitHubOAuth2Service;
    @GetMapping("/login/github")
    public ResponseEntity<Object> redirectToGitHubAuthorization() {
        String authorizationUri = "https://github.com/login/oauth/authorize" +
                "?client_id=" + clientId +
                "&redirect_uri=" + redirectUri +
                "&scope=" + scope1 + "&scope=" + scope2;

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, authorizationUri);
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

    @GetMapping("/login/github/oauth2/code/github")
    public ResponseEntity<Object> githubCallback(@RequestParam("code") String code) {

        OAuth2AccessToken accessToken = gitHubOAuth2Service.getAccessToken(code);
        GitHubUserInfo userInfo = gitHubOAuth2Service.getUserInfo(accessToken);
        log.info(userInfo);
        return ResponseEntity.ok("Đăng nhập thành công với GitHub!");
    }
}
