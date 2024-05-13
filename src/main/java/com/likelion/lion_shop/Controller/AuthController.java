package com.likelion.lion_shop.Controller;

import com.likelion.lion_shop.Dto.response.JwtDto;
import com.likelion.lion_shop.service.AuthService;
import com.likelion.lion_shop.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    //토큰 재발급 API
    @PostMapping("/reissue")
    public ResponseEntity<?> reissue(@RequestBody JwtDto jwtDto) {

        log.info("[ Auth Controller ] 토큰을 재발급합니다. ");

        return ResponseEntity.ok(authService.reissueToken(jwtDto));
    }
}
