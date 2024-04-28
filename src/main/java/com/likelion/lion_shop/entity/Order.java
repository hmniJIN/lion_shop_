package com.likelion.lion_shop.entity;

import com.likelion.lion_shop.Dto.UpdateOrderRequestDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="order")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long orderid;//Order의 pk값

    @Column
    public String name;
    @Column
    public int quantity;
    @Column
    public int price;

    //Dto를 이용해 업데이트
    public void update(UpdateOrderRequestDto updateOrderRequestDto) {
        name = updateOrderRequestDto.getName();
        quantity = updateOrderRequestDto.getQuantity();
        price = updateOrderRequestDto.getPrice();
    }


}
