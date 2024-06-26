package com.likelion.lion_shop.entity;

import com.likelion.lion_shop.Dto.request.UpdateUserRequestDto;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String address;

    @Column
    private String roles;

    @Column
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;

    //Dto를 사용해 업데이트
    public void update(UpdateUserRequestDto updateUserRequestDto){
        name = updateUserRequestDto.getName();
        address = updateUserRequestDto.getAddress();
    }
}
