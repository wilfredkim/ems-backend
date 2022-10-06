package com.wilfred.emsbackend.emsbackend.services;

import com.wilfred.emsbackend.emsbackend.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);

    Employee findById(Long id);

    void deleteById(Long id);

    List<Employee> getList();
}
