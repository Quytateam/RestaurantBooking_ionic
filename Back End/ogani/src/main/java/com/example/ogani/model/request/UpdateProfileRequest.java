package com.example.ogani.model.request;

// import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProfileRequest {

    private String username;

    private String name;

<<<<<<< HEAD
=======
    // private String email;

>>>>>>> origin/master
    private String address;

    private String phone;
}
