package com.san.webapp.service;

import com.san.webapp.model.Employee;
import com.san.webapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository empRepository;

    public List getAllEmployee(){
        List empList = new ArrayList();
        return empRepository.findAll();
        //return empList;
    }
    public Employee getEmployeeById(int id){
        return empRepository.findById(id).get();
    }

    public void saveOrUpdate(Employee emp){
        empRepository.save(emp);

    }

    public void delete(int id){
        empRepository.deleteById(id);
    }

}
