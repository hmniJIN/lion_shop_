package com.likelion.lion_shop.Dto.response;

import com.likelion.lion_shop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    public String email;
    public Long id;
    public String name;
    public String address;

    public static UserResponseDto from(User user){
        return UserResponseDto.builder()
                .email(user.getEmail())
                .id(user.getId())
                .name(user.getName())
                .address(user.getAddress())
                .build();
    }
}
