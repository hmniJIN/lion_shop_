package com.likelion.lion_shop.Repository;

import com.likelion.lion_shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

}
