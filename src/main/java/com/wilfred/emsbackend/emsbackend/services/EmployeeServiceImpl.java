package com.wilfred.emsbackend.emsbackend.services;

import com.wilfred.emsbackend.emsbackend.exceptions.ResourceNotFoundException;
import com.wilfred.emsbackend.emsbackend.model.Employee;
import com.wilfred.emsbackend.emsbackend.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository repository;

    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee findById(Long id) {
        Optional<Employee> optionalEmployee = repository.findById(id);
        return optionalEmployee.orElseThrow(() -> new ResourceNotFoundException("Cannot find employee with id : " + id));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Employee> getList() {
        return repository.findAll();
    }
}
