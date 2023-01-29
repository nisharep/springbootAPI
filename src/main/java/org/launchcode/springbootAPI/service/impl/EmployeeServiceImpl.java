package org.launchcode.springbootAPI.service.impl;

import org.launchcode.springbootAPI.exception.ResourceNotFoundException;
import org.launchcode.springbootAPI.repository.EmployeeRepository;
import org.launchcode.springbootAPI.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.launchcode.springbootAPI.model.Employee;
import org.launchcode.springbootAPI.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        /*
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        else{
            throw new ResourceNotFoundException("Employee", "Id", id);
        }*/
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        // 1ST STEP: To check whether the employee id present in the data base or not.
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));
        // Check whether the employee exists in data or not
        employeeRepository.deleteById(id);
    }



}
