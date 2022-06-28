package com.skytech.producer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skytech.producer.entities.Employee;
@Repository
public interface HRMRepository extends JpaRepository<Employee, Integer>{

}
