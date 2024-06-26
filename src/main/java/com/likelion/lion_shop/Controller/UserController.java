package com.likelion.lion_shop.Controller;

import com.likelion.lion_shop.Dto.response.UserResponseDto;
import com.likelion.lion_shop.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//추가
import org.springframework.web.bind.annotation.*;
import com.likelion.lion_shop.Dto.request.CreateUserRequestDto;
import com.likelion.lion_shop.Dto.request.UpdateUserRequestDto;

//다시 제출
@Slf4j //로그 출력을 도와주는 어노테이션
@RestController
@RequiredArgsConstructor
@RequestMapping("/user") // uri가 http://~/user로 시작하는 요청을 받습니다.
public class UserController {


    private final UserService userService;



    // 1. 사용자를 생성하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용하여 사용자의 이름, 주소, ID, PW를 출력해줍니다. return 값은 "사용자 생성"입니다.
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequestDto createUserRequestDto){
        UserResponseDto responseDto = userService.createUser(createUserRequestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
    // 2. 사용자를 조회하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용하여 사용자의 ID를 출력해줍니다. return 값은 "사용자 조회"입니다.
    @GetMapping()
    public ResponseEntity<?> getUser(@AuthenticationPrincipal UserDetails userDetails){
        UserResponseDto responseDto = userService.getUser(userDetails.getUsername());
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }

    // 3. 사용자를 수정하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용를여 사용자의 이름, 주소를 출력해줍니다. return 값은 "사용자 수정"입니다.
    @PutMapping()
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserRequestDto updateUserRequestDto, @AuthenticationPrincipal UserDetails userDetails){
        UserResponseDto responseDto = userService.updateUser(updateUserRequestDto, userDetails.getUsername());
        return ResponseEntity.ok(responseDto);
    }
    // 4. 사용자를 삭제하는 컨트롤러를 만듭니다.
    // 이때 log.info 이용하여 사용자의 ID를 출력해줍니다. return 값은 "사용자 삭제"입니다.
    @DeleteMapping()
    public ResponseEntity<?> deleteUser(@AuthenticationPrincipal UserDetails userDetails){
        userService.deleteUser(userDetails.getUsername());
        return ResponseEntity.noContent().build();
    }
}