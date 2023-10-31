package com.example.firstproject.controller;

import com.example.firstproject.Model.Employee;
import com.example.firstproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping ("/add")
    public Employee add(@RequestBody Employee employee){
        return employeeService.insert(employee);
    }

    @GetMapping("/get/{id}")
    public Employee getemployee(@PathVariable("id") int id){
        return employeeService.getemployee(id);

    }
  @DeleteMapping("/delete/{id}")
    public String Employeedelete(@PathVariable("id") int id){

        return employeeService.deletemployee(id);
    }

    @PutMapping("/edit")
    public String editSalary(@RequestParam ("id") int id,@RequestParam ("salary") int salary){
        return employeeService.editSalary(id,salary);
    }

    @PutMapping("/Editname")
    public String editname(@RequestParam("id") int id,@RequestParam("employeeName") String employeeName){
        return employeeService.editname(id,employeeName);
    }






}
