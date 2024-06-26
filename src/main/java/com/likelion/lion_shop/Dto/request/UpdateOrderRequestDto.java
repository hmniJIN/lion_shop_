package com.likelion.lion_shop.Dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor //매개변수 없는 생성자를 생성해 줍니다.
@AllArgsConstructor //모든 매개변수를 받는 생성자를 생성해 줍니다.
@Getter
public class UpdateOrderRequestDto {

    //상품 id
    public Long id;

    //상품 이름
    public String name;

    //수량
    public int quantity;

    //가격
    public int price;

}