package com.eylmz.micro.cleanarchitecture.repository;

import com.eylmz.micro.cleanarchitecture.dao.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}