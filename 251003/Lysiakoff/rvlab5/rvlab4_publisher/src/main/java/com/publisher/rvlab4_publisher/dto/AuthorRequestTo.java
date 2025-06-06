package com.publisher.rvlab4_publisher.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorRequestTo {
    private Long id;
    private String login;
    private String password;
    private String firstname;
    private String lastname;
}
