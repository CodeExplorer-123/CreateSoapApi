package com.example.SoapApiProject.repository;

import com.example.SoapApiProject.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {
}
