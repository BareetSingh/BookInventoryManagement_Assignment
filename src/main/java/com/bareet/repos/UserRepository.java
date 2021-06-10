package com.bareet.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bareet.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
