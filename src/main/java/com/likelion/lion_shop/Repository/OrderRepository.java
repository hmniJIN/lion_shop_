package com.likelion.lion_shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.likelion.lion_shop.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
