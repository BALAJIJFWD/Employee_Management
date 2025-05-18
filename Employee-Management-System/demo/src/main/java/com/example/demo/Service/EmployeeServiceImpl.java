package com.example.demo.Service;

import org.hibernate.FetchNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Employee;
import com.example.demo.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public void saveEmployee(Employee employee) {
    employeeRepository.save(employee);
  }

  @Override
  public Iterable<Employee> findEmployees() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee getEmployeeId(Integer id) {
    Employee employee = employeeRepository.findById(id).orElseThrow(() -> new FetchNotFoundException("Employee", id));
    return employee;
  }

  @Override
  public void deleteEmployee(Integer id) {
    employeeRepository.deleteById(id);
  }

}
