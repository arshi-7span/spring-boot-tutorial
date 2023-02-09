package com.example.repository;

import com.example.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    List<User> findByUserName(String uname);

    List<User> findByUserNameAndPassword(String uname,String pwd);

    List<User> findByUserNameOrPassword(String uname,String pwd);

    List<User> findByUserNameLike(String uname);
}
