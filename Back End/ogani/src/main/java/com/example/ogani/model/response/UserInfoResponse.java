package com.example.ogani.model.response;

import java.util.List;
<<<<<<< HEAD
=======
import java.util.Set;

import com.example.ogani.entity.Role;
>>>>>>> origin/master

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoResponse {
    private long id;

    private String username;

    private String email;

    private List<String> roles;
}
