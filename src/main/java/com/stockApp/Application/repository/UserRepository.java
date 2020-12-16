package com.stockApp.Application.repository;

import com.stockApp.Application.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByUsername(String name);
    
    // Sample on how to input custom query
    @Query(nativeQuery = true, value = "select * from user where something.....")
    List<User> searchUser();
}
