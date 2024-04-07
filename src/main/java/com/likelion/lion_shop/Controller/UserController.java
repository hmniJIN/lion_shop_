package com.likelion.lion_shop.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//추가
import org.springframework.web.bind.annotation.*;
import com.likelion.lion_shop.Dto.CreateUserRequestDto;
import com.likelion.lion_shop.Dto.UpdateUserRequestDto;

//다시 제출
@Slf4j //로그 출력을 도와주는 어노테이션
@RestController
@RequestMapping("/user") // uri가 http://~/user로 시작하는 요청을 받습니다.
public class UserController {

    // 1. 사용자를 생성하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용하여 사용자의 이름, 주소, ID, PW를 출력해줍니다. return 값은 "사용자 생성"입니다.
    @PostMapping("/create")
    public String createUser(@RequestBody CreateUserRequestDto createUserRequestDto){
        log.info("name={}", createUserRequestDto.getName());
        log.info("address={}", createUserRequestDto.getAddress());
        log.info("ID={}", createUserRequestDto.getId());
        log.info("PW={}", createUserRequestDto.getPassword());
        return "사용자 생성";
    }
    // 2. 사용자를 조회하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용하여 사용자의 ID를 출력해줍니다. return 값은 "사용자 조회"입니다.
    @GetMapping("/{userID}")
    public String getUser(@PathVariable long userID){
        log.info("ID={}",userID );
        return "사용자 조회";
    }

    // 3. 사용자를 수정하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용를여 사용자의 이름, 주소를 출력해줍니다. return 값은 "사용자 수정"입니다.
    @PutMapping("/{userID}")
    public String updateUser(@PathVariable long userID, @RequestBody UpdateUserRequestDto updateUserRequestDto){
        log.info("name={}", updateUserRequestDto.getName());
        log.info("address={}", updateUserRequestDto.getAddress());
        return "사용자 수정";
    }
    // 4. 사용자를 삭제하는 컨트롤러를 만듭니다.
    // 이때 log.info 이용하여 사용자의 ID를 출력해줍니다. return 값은 "사용자 삭제"입니다.
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable long userId){
        log.info("ID={}", userId);
        return "사용자 삭제";
    }
}