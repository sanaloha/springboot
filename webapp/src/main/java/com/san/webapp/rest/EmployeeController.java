package com.san.webapp.rest;

import com.san.webapp.model.Employee;
import com.san.webapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService empService;

    @GetMapping("/")
    private String getEmp(){
        return "Welcome";
    }
    @GetMapping("/employee")
    private List<Employee> getEmployee(){
        return empService.getAllEmployee();
    }
    @GetMapping("/employee/{id}")
    private Employee getEmployeeById(@PathVariable("id") int id){
        return empService.getEmployeeById(id);
    }
    @PostMapping("/employees")
    private ResponseEntity createEmployee(@RequestBody Employee emp) {
        try {
            empService.saveOrUpdate(emp);
        }catch (Exception ex){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity("Created new emp id"+emp.getId(), HttpStatus.CREATED);
    }

}
