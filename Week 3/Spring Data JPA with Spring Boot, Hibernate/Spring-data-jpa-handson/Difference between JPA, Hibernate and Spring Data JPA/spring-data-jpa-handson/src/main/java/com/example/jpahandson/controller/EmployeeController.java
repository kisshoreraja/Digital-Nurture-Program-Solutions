package com.example.jpahandson.controller;

import com.example.jpahandson.entity.Employee;
import com.example.jpahandson.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return repository.save(employee);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee updated) {
        return repository.findById(id).map(emp -> {
            emp.setName(updated.getName());
            emp.setRole(updated.getRole());
            return repository.save(emp);
        }).orElseGet(() -> {
            updated.setId(id);
            return repository.save(updated);
        });
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
