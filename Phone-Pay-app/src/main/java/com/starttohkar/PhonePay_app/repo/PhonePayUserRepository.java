package com.starttohkar.PhonePay_app.repo;

import com.starttohkar.PhonePay_app.model.PhonePayUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<PhonePayUsers,Long> {
    PhonePayUsers findByName(String name);
}