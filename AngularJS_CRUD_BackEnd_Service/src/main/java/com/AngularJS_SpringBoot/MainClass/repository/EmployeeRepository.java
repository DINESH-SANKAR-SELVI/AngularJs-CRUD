package com.AngularJS_SpringBoot.MainClass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AngularJS_SpringBoot.MainClass.model.*;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee ,Long> {

}
