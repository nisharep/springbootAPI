package org.launchcode.springbootAPI.controller;


import org.launchcode.springbootAPI.model.Employee;
import org.launchcode.springbootAPI.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    //build create employee REST API
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){

        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    //build get all employees  REST API
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    //get a employee by the empID REST API
    @GetMapping("{id}")
    public ResponseEntity <Employee> getEmployeeById(@PathVariable("id") long empId){

        return new ResponseEntity<Employee>(employeeService.getEmployeeById(empId), HttpStatus.OK);

    }

    //build update employee rest api
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,
                                                   @RequestBody Employee employee){

        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    //Build delete employee rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){

        employeeService.deleteEmployee(id);
        return  new ResponseEntity<String>("Employee has been deleted successfully!", HttpStatus.OK);

    }

}
