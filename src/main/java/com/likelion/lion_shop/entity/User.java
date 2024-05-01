package com.likelion.lion_shop.entity;

import com.likelion.lion_shop.Dto.UpdateUserRequestDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String id;

    @Column
    public String name;

    @Column
    public String password;

    @Column
    public String address;

    //Dto를 사용해 업데이트
    public void update(UpdateUserRequestDto updateUserRequestDto){
        name = updateUserRequestDto.getName();
        address = updateUserRequestDto.getAddress();
    }
}
