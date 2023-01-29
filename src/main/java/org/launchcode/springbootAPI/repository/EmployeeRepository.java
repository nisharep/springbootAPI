package org.launchcode.springbootAPI.repository;

import org.launchcode.springbootAPI.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
