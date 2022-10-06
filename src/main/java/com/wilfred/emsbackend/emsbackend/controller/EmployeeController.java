package com.wilfred.emsbackend.emsbackend.controller;

import com.wilfred.emsbackend.emsbackend.model.Employee;
import com.wilfred.emsbackend.emsbackend.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getList() {
        return employeeService.getList();
    }

    @PostMapping("/addemployee")
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }
}
