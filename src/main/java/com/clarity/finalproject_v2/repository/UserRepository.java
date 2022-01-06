package com.clarity.finalproject_v2.repository;


import com.clarity.finalproject_v2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from users as u where u.user_name = :userName", nativeQuery = true)
    User findUser(String userName);
}
