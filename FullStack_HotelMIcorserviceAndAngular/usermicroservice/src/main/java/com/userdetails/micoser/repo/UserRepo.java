package com.userdetails.micoser.repo;

import com.userdetails.micoser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

}
