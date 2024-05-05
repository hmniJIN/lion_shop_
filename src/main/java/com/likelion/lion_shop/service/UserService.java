package com.likelion.lion_shop.service;

import com.likelion.lion_shop.Dto.CreateUserRequestDto;
import com.likelion.lion_shop.Dto.UpdateUserRequestDto;
import com.likelion.lion_shop.Dto.response.UserResponseDto;
import com.likelion.lion_shop.Repository.UserRepository;
import com.likelion.lion_shop.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j //로그 출력을 도와주는 어노테이션
@Service
@RequiredArgsConstructor//DI 생성자 주입을 임의의 코드없이 자동으로 설정해주는 어노테이션
@Transactional
public class UserService {
    private final UserRepository userRepository;

    //사용자 생성
    public UserResponseDto createUser(CreateUserRequestDto createUserRequestDto) {
        User user = createUserRequestDto.toEntity();
        userRepository.save(user);

        log.info("사용자 생성하기, 이름 : {}", user.getName());
        log.info("사용자 생성하기, ID : {}", user.getId());
        log.info("사용자 생성하기, 비밀번호 : {}", user.getPassword());
        log.info("사용자 생성하기, 주소 : {}", user.getAddress());

        return UserResponseDto.from(user);
    }

    @Transactional(readOnly = true)//조회하기만
    //사용자 가져오기
    public UserResponseDto getUser(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));

        log.info("사용자 정보 가져오기");
        log.info("이름 : {}", user.getName());
        log.info("ID : {}", user.getId());
        log.info("주소 : {}", user.getAddress());

        return UserResponseDto.from(user);
    }
    //사용자 수정하기
    public UserResponseDto updateUser(UpdateUserRequestDto updateUserRequestDto){
        long id = updateUserRequestDto.getId();
        User user = userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        user.update(updateUserRequestDto);
        userRepository.save(user);

        log.info("사용자 수정하기");
        log.info("이름 : {}", user.getName());
        log.info("비밀번호: {}", user.getPassword());
        log.info("주소 : {}", user.getAddress());

        return UserResponseDto.from(user);
    }

    //사용자 삭제하기
    public void deleteUser(Long id){
        User user = userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 사용자입니다."));
        userRepository.deleteById(id);

        log.info("사용자가 삭제되었습니다.");

    }
}
