package com.example.cogosharing.controller;


import com.example.cogosharing.dto.user.LoginRequestDto;
import com.example.cogosharing.dto.user.LoginResponseDto;
import com.example.cogosharing.dto.user.RegisterRequestDto;
import com.example.cogosharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    //의존성 주입 -> 생성자 주입 방식
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원가입 엔드포인트
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequestDto registerRequestDto) {
        userService.registerUser(registerRequestDto);
        return ResponseEntity.ok().body("회원가입 성공");
    }

    // 로그인 엔드포인트
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequestDto loginRequestDto) {
        String token = userService.loginUser(loginRequestDto);
        return ResponseEntity.ok().body(new LoginResponseDto(token));
    }

    // 로그아웃 엔드포인트
    // JWT 기반 인증에서는 서버에서 별도의 로그아웃 처리가 필요 없을 수 있음
    // 클라이언트 측에서 토큰을 삭제하는 방식으로 로그아웃을 처리
    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        return ResponseEntity.ok().body("로그아웃 성공");
    }
}


