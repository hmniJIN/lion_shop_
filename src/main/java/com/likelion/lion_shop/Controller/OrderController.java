package com.likelion.lion_shop.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
//추가
import com.likelion.lion_shop.Dto.CreateOrderRequestDto;
import com.likelion.lion_shop.Dto.UpdateOrderRequestDto;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/order") // uri가 http://~/user로 시작하는 요청을 받습니다.
public class OrderController {
    // 1. 주문을 생성하는 컨트롤러를 만듭니다. 이때 return 값은 "주문 생성하기"입니다. -> 주문은 리스트 형태로 요청을 보내주세요!
    @PostMapping("/create")
    public String createOrder(@RequestBody List<CreateOrderRequestDto> CreateOrderlist){
        return "주문 생성하기";
    }
    // 2. 주문을 가져오는 컨트롤러를 만듭니다. 이때 return 값은 "주문 가져오기"입니다.
    @GetMapping("/{orderID}")
    public String getOrder(@PathVariable long orderID){
        return "주문 가져오기";
    }
    // 3. 주문을 수정하는 컨트롤러를 만듭니다. 이때 return 값은 "주문 수정하기"입니다.
    @PutMapping("/{orderID}")
    public String updateOrder(@PathVariable long orderID, @RequestBody UpdateOrderRequestDto updateOrderRequestDto){
        return "주문 수정하기";
    }
    // 4. 주문을 삭제하는 컨트롤러를 만듭니다. 이때 return 값은 "주문 삭제하기"입니다.
    @DeleteMapping("/{orderID}")
    public String deleteOrder(@PathVariable long orderID){
        return "주문 삭제하기";
    }

}