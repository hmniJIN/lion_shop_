package com.likelion.lion_shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.likelion.lion_shop.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long>{

}
