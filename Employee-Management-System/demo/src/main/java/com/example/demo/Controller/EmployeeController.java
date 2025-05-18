package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.Entity.Employee;
import com.example.demo.Service.EmployeeService;



@Controller
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/employees")
  public String employees(Model model) {
    model.addAttribute("employees", employeeService.findEmployees());
    return "employees";
  }
  

  @GetMapping("/register")
  public String registration(Model model){
    Employee employee = new Employee();
    model.addAttribute("employee",employee);
    return "registration";
  }

  @PostMapping("/saveEmployee")
  public String saveEmployee(@ModelAttribute("employee") Employee employee) {
      employeeService.saveEmployee(employee);
      return "redirect:/employees";
  }

  @GetMapping("/updateEmployee/{id}")
  public String updateEmployee(Model model,@PathVariable Integer id){
    Employee employee = employeeService.getEmployeeId(id);
    model.addAttribute("employee", employee);
    return "updateForm";
  }

  @GetMapping("/deleteEmployee/{id}")
  public String delete(@PathVariable Integer id){
    employeeService.deleteEmployee(id);
    return "redirect:/employees";
  }

  @GetMapping("/viewEmployee/{id}")
  public String viewEmployee(@PathVariable Integer id, Model model) {
    Employee employee = employeeService.getEmployeeId(id);
    model.addAttribute("employee", employee);
    return "view";
  }

  


}
