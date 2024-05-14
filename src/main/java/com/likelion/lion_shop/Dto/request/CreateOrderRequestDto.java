package com.likelion.lion_shop.Dto.request;

import com.likelion.lion_shop.entity.Order;
import com.likelion.lion_shop.entity.User;
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

    public User user; //OrderService에서 존재하는 사용자인지 조회를 위해

    //Order Dto-> Order Entity로 변환
    public Order toEntity(){
        return Order.builder()
                .user(user)
                .name(name)
                .quantity(quantity)
                .price(price)
                .build();
    }

}