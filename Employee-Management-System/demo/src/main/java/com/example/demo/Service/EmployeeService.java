package com.example.demo.Service;

import com.example.demo.Entity.Employee;

public interface EmployeeService {

  void saveEmployee(Employee employee);
  Iterable<Employee> findEmployees();
  Employee getEmployeeId(Integer id);
  void deleteEmployee(Integer id);

}
