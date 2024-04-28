package com.likelion.lion_shop.Dto.response;

import com.likelion.lion_shop.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter//Dto-> Json으로 직렬화 시행시, 스프링 @Getter를 이용해 DTO 필드를 가져옴
@Builder
/*
*<빌더패턴>
* 객체 생성 및 초기화에 대한 유연성과 가독성을 제공하는 디자인패턴-> 생성자 대신 사용
* [사용이유]
* 필요한 데이터만 설정 가능, 유연성 & 가독성 좋음
*  */
@NoArgsConstructor//매개변수 없는 생성자 생성
@AllArgsConstructor//모든 필드 값을 파라미터로 받는 생성자 생성
/*@Builder를 통해 필요한 파라미터만 받아서 객체 만들 수 있고, 전체 파라미터를 받아서 객체를 만들 수 있음
* 만약 생성자 어노테이션을 추가X-> 모든 필드를 받는 파라미터로 사용하는 생성자 생성
*
* @NoArgsConstructor + @Builder(가장 효율적으로 필요한 객체만을 생성해서 사용하기 위한 좋은 방법)
* => @AllArgsConstructor가 필요함*/
public class OrderResponseDto {
    public Long id;
    public String name;
    public int quantity;
    public int price;

    public static OrderResponseDto from(Order order){
        return OrderResponseDto.builder()
                .id(order.getOrderid())
                .name(order.getName())
                .quantity(order.getQuantity())
                .price(order.getPrice())
                .build();
    }
}