package com.likelion.lion_shop.service;


import com.likelion.lion_shop.Dto.CreateOrderRequestDto;
import com.likelion.lion_shop.Dto.UpdateOrderRequestDto;
import com.likelion.lion_shop.Dto.response.OrderResponseDto;
import com.likelion.lion_shop.Repository.OrderRepository;
import com.likelion.lion_shop.Repository.UserRepository;
import com.likelion.lion_shop.entity.Order;
import com.likelion.lion_shop.entity.User;
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
    private final UserRepository userRepository;

    //주문 생성
    public List<OrderResponseDto> createOrder(List<CreateOrderRequestDto> createOrderRequestDtoList) {
        List<Order> createdOrders = new ArrayList<>();
        for(CreateOrderRequestDto createOrderRequestDto : createOrderRequestDtoList) {
            String name = createOrderRequestDto.getName();
            double price = createOrderRequestDto.getPrice();
            int quantity = createOrderRequestDto.getQuantity();
            User user = userRepository.findById(createOrderRequestDto.getUser().getId()).orElseThrow(()->new IllegalArgumentException("사용자가 존재하지 않습니다."));
            Order savedOrder = orderRepository.save(createOrderRequestDto.toEntity());
            createdOrders.add(savedOrder);
        }
        return OrderResponseDto.from(createdOrders);

    }
    @Transactional(readOnly = true)//조회하기만
    //주문 가져오기
    public OrderResponseDto getOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 주문입니다."));

        return OrderResponseDto.from(order);
    }

    //주문 수정하기
    public OrderResponseDto updateOrder(UpdateOrderRequestDto updateOrderRequestDto) {
        Long orderId = updateOrderRequestDto.getId();
        Order order = orderRepository.findById(orderId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 주문입니다."));

        order.update(updateOrderRequestDto);//수정
        orderRepository.save(order);//저장

        return OrderResponseDto.from(order);
    }

    //주문 삭제하기
    public void deleteOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 주문입니다."));

        orderRepository.deleteById(orderId);
        log.info("주문이 삭제되었습니다.");
    }
}
