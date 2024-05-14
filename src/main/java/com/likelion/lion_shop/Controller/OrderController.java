package com.likelion.lion_shop.Controller;

import com.likelion.lion_shop.Dto.response.OrderResponseDto;
import com.likelion.lion_shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
//추가
import com.likelion.lion_shop.Dto.request.CreateOrderRequestDto;
import com.likelion.lion_shop.Dto.request.UpdateOrderRequestDto;
import java.util.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/order") // uri가 http://~/user로 시작하는 요청을 받습니다.
public class OrderController {


    private final OrderService orderService;



    // 1. 주문을 생성하는 컨트롤러를 만듭니다. 이때 return 값은 "주문 생성하기"입니다. -> 주문은 리스트 형태로 요청을 보내주세요!
    @PostMapping("/create")
    public ResponseEntity<List<OrderResponseDto>> createOrder(@RequestBody List<CreateOrderRequestDto> orders, @AuthenticationPrincipal UserDetails userDetails){
        List<OrderResponseDto> responseDto = orderService.createOrder(orders);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    // 2. 주문을 가져오는 컨트롤러를 만듭니다. 이때 return 값은 "주문 가져오기"입니다.
    @GetMapping("/{orderId}")
    public ResponseEntity getOrder(@PathVariable("orderId") Long orderId, @AuthenticationPrincipal UserDetails userDetails){
        OrderResponseDto responseDto = orderService.getOrder(orderId);

        return ResponseEntity.ok(responseDto);
    }

    // 3. 주문을 수정하는 컨트롤러를 만듭니다. 이때 return 값은 "주문 수정하기"입니다.
    @PutMapping("/{orderId}")
    public ResponseEntity<?> updateOrder(@PathVariable("orderId") Long orderId, @RequestBody UpdateOrderRequestDto updateOrderRequestDto, @AuthenticationPrincipal UserDetails userDetails){
        OrderResponseDto responseDto = orderService.updateOrder(updateOrderRequestDto, orderId);
        return ResponseEntity.ok(responseDto);
    }

    // 4. 주문을 삭제하는 컨트롤러를 만듭니다. 이때 return 값은 "주문 삭제하기"입니다.
    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("orderId") Long orderId, @AuthenticationPrincipal UserDetails userDetails){
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }

}