package com.finalsem.projectsem4.github;

import lombok.Data;

@Data
public class GitHubUserInfo {

    private String login; // Tên đăng nhập (username)
    private String name; // Tên người dùng
    private String email; // Email người dùng
    private String avatarUrl; // URL của ảnh đại diện

}
