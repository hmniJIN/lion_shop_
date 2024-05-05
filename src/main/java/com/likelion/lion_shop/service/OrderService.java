package com.likelion.lion_shop.service;


import com.likelion.lion_shop.Dto.CreateOrderRequestDto;
import com.likelion.lion_shop.Dto.UpdateOrderRequestDto;
import com.likelion.lion_shop.Dto.response.OrderResponseDto;
import com.likelion.lion_shop.Repository.OrderRepository;
import com.likelion.lion_shop.entity.Orders;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor//DI 생성자 주입을 임의의 코드없이 자동으로 설정해주는 어노테이션
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;

    //주문 생성
    public void creatOrder(List<CreateOrderRequestDto> createOrderRequestDtoList) {
        createOrderRequestDtoList.forEach(orderRequestDto -> {
            Orders orders =orderRequestDto.toEntity();
            log.info("주문 생성하기, 이름:{}", orderRequestDto.getName());
            log.info("주문 생성하기, 수량:{}", orderRequestDto.getQuantity());
            log.info("주문 생성하기, 가격:{}", orderRequestDto.getPrice());

            orderRepository.save(orders);
        });

    }
    @Transactional(readOnly = true)//조회하기만
    //주문 가져오기
    public OrderResponseDto getOrder(Long orderId) {
        Orders orders = orderRepository.findById(orderId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 주문입니다."));

        log.info("주문을 가져오기");
        log.info("ID: {}", orderId);
        log.info("이름: {}", orders.getName());
        log.info("수량: {}", orders.getQuantity());
        log.info("가격: {}", orders.getPrice());

        return OrderResponseDto.from(orders);
    }

    //주문 수정하기
    public OrderResponseDto updateOrder(UpdateOrderRequestDto updateOrderRequestDto) {
        Long orderId = updateOrderRequestDto.getId();
        Orders orders = orderRepository.findById(orderId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 주문입니다."));

        orders.update(updateOrderRequestDto);//수정
        orderRepository.save(orders);//저장

        log.info("주문 수정하기");
        log.info("ID : {}", orderId);
        log.info("이름: {}", orders.getName());
        log.info("수량: {}", orders.getQuantity());
        log.info("가격: {}", orders.getPrice());

        return OrderResponseDto.from(orders);
    }

    //주문 삭제하기
    public void deleteOrder(Long orderId) {
        Orders orders = orderRepository.findById(orderId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 주문입니다."));

        orderRepository.deleteById(orderId);
        log.info("주문이 삭제되었습니다.");
    }
}
