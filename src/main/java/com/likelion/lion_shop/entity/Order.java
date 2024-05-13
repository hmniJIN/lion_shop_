package com.likelion.lion_shop.entity;

import com.likelion.lion_shop.Dto.request.UpdateOrderRequestDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orders")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//Order의 pk값

    @Column
    private String name;
    @Column
    private int quantity;
    @Column
    private int price;

    @ManyToOne(fetch=FetchType.LAZY)
    private User user;

    //Dto를 이용해 업데이트
    public void update(UpdateOrderRequestDto updateOrderRequestDto) {
        name = updateOrderRequestDto.getName();
        quantity = updateOrderRequestDto.getQuantity();
        price = updateOrderRequestDto.getPrice();
    }


}
