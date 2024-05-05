package com.likelion.lion_shop.Dto;

import com.likelion.lion_shop.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor //매개변수 없는 생성자를 생성해 줍니다.
@AllArgsConstructor //모든 매개변수를 받는 생성자를 생성해 줍니다.
@Getter
public class CreateOrderRequestDto {

    //상품 이름
    public String name;

    //수량
    public int quantity;

    //가격
    public int price;

    //Order Dto-> Order Entity로 변환
    public Orders toEntity(){
        return Orders.builder()
                .name(name)
                .quantity(quantity)
                .price(price)
                .build();
    }

}