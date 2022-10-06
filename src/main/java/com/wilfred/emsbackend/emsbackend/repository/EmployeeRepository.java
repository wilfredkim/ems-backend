package com.wilfred.emsbackend.emsbackend.repository;

import com.wilfred.emsbackend.emsbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
