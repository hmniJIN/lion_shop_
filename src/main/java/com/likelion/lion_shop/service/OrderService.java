package com.likelion.lion_shop.service;


import com.likelion.lion_shop.Dto.CreateOrderRequestDto;
import com.likelion.lion_shop.Dto.UpdateOrderRequestDto;
import com.likelion.lion_shop.Dto.response.OrderResponseDto;
import com.likelion.lion_shop.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j

public class OrderService {
    //주문 생성
    public void creatOrder(List<CreateOrderRequestDto> createOrderRequestDtoList) {
        createOrderRequestDtoList.forEach(orderRequestDto -> {
            log.info("주문 생성하기, 이름:{}", orderRequestDto.getName());

            Order order = orderRequestDto.toEntity();
        });
    }
    //주문 가져오기
    public OrderResponseDto getOrder(Long orderId) {
        log.info("주문 가져오기, ID: {}", orderId);

        //임시
        Order order = new Order();

        return OrderResponseDto.from(order);
    }

    //주문 수정하기
    public void updateOrder(UpdateOrderRequestDto updateOrderRequestDto) {
        log.info("주문 수정하기, ID : {}", updateOrderRequestDto.getOrderid());

        //임시
        Order order = new Order();

        order.update(updateOrderRequestDto);

    }

    //주문 삭제하기
    public void deleteOrder(Long orderId) {
        log.info("주문 삭제하기, ID: {}", orderId);
    }
}
