package com.example.firstproject.service;

import com.example.firstproject.Model.Employee;
import com.example.firstproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee insert(Employee employee){
        return employeeRepository.save(employee);
    }



    public Employee getemployee(int id){
        return employeeRepository.findById(id).get();
    }
        public String deletemployee(int id){
        Employee employee=employeeRepository.findById(id).get();
        String mobNo =employee.getMobNo();

        employeeRepository.deleteById(id);
        return mobNo+"successfully deleted";

    }

    public String editSalary(int id,int salary){
        Employee employee=employeeRepository.findById(id).get();

        employee.setSalary(salary);
        employeeRepository.save(employee);
        return "Successfull";
    }
    public String editname(int id,String EmployeeName){
        Employee employee=employeeRepository.findById(id).get();

        String oldname=employee.getEmployeeName();



        employee.setEmployeeName(EmployeeName);

        Employee savedEmployee=employeeRepository.save(employee);
        return oldname+" succesfully changed to "+savedEmployee.getEmployeeName();

       // return savedEmployee.getEmployeeName()+" Succesfully changed";


    }


}
