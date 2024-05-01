package com.likelion.lion_shop.service;

import com.likelion.lion_shop.Dto.CreateUserRequestDto;
import com.likelion.lion_shop.Dto.UpdateUserRequestDto;
import com.likelion.lion_shop.Dto.response.UserResponseDto;
import com.likelion.lion_shop.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j //로그 출력을 도와주는 어노테이션
@Service

public class UserService {
    //사용자 생성
    public void createUser(CreateUserRequestDto createUserRequestDto) {
        log.info("사용자 생성하기, 이름 : {}", createUserRequestDto.getName());

        User user = createUserRequestDto.toEntity();

    }
    //사용자 가져오기
    public UserResponseDto getUser(String id){
        log.info("사용자 가져오기, ID : {}",id);

        //임시
        User user = new User();

        return UserResponseDto.from(user);
    }
    //사용자 수정하기
    public void updateUser(UpdateUserRequestDto updateUserRequestDto){
        log.info("사용자 수정하기, ID : {}", updateUserRequestDto.getId());

        //임시
        User user = new User();

        user.update(updateUserRequestDto);

    }

    //사용자 삭제하기
    public void deleteUser(String id){
        log.info("사용자 삭제하기, ID : {}", id);

    }
}
