package com.wilfred.emsbackend.emsbackend.controller;

import com.wilfred.emsbackend.emsbackend.exceptions.ResourceNotFoundException;
import com.wilfred.emsbackend.emsbackend.model.Employee;
import com.wilfred.emsbackend.emsbackend.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
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

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok().body(employeeService.findById(id));
    }

    @PutMapping("employees/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee employee = employeeService.findById(id);
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());
        return ResponseEntity.ok().body(employeeService.save(employee));
    }

    @DeleteMapping("employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        employeeService.deleteById(employee.getId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted Successfully",Boolean.TRUE);
        return ResponseEntity.ok().body(response);
    }

}
