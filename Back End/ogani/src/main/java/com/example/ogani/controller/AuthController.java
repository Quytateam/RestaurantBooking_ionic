package com.example.ogani.controller;

<<<<<<< HEAD
import java.util.List;
import java.util.stream.Collectors;

=======
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
>>>>>>> origin/master
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ogani.model.request.CreateUserRequest;
import com.example.ogani.model.request.LoginRequest;
import com.example.ogani.model.response.MessageResponse;
import com.example.ogani.model.response.UserInfoResponse;
import com.example.ogani.security.jwt.JwtUtils;
import com.example.ogani.security.service.UserDetailsImpl;
import com.example.ogani.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*",maxAge = 3600)
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @Operation(summary="Đăng nhập")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
         Authentication authentication = authenticationManager
                 .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                         loginRequest.getPassword()));

         SecurityContextHolder.getContext().setAuthentication(authentication);

         UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

         if (userDetails.getEnable() == 0) {
<<<<<<< HEAD
=======
            // Nếu tài khoản chưa được kích hoạt, bạn có thể trả về một thông báo lỗi hoặc mã lỗi tùy ý.
>>>>>>> origin/master
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Tài khoản chưa được kích hoạt.");
        }

         ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

         List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

         return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
               .body(new UserInfoResponse(userDetails.getId(),
                       userDetails.getUsername(),
                       userDetails.getEmail(),
                       roles));
<<<<<<< HEAD
=======
        //   return ResponseEntity.ok(jwtCookie);
>>>>>>> origin/master
    }

    @PostMapping("/register")
    @Operation(summary="Đăng ký")
    public ResponseEntity<?> register(@Valid @RequestBody CreateUserRequest request){
      
        userService.register(request);
      
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/logout")
    @Operation(summary="Đăng xuất")
    public ResponseEntity<?> logoutUser() {
      ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
      return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
          .body(new MessageResponse("You've been logout!"));
    }
}
