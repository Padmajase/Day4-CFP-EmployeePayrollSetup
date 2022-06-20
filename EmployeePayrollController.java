package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    // curl localhost:8080/employeepayrollservice -w "\n"
    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<String> getEmployeePayrollData() {
        return new ResponseEntity<String>("Get Call Success ", HttpStatus.OK);
    }

    // curl localhost:8080/employeepayrollservice/get/{empId} -w "\n"
    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeePayrollData(@PathVariable("empId") int empId) {
        return  new ResponseEntity<String>("Get Call Success for id "+empId, HttpStatus.OK);
    }

    // curl -X POST -H "Content-Type: application/json"
    // -d '{"firstName" : "Padmaja", "salary" : "20000"}'
    // curl localhost:8080/employeepayrollservice/create -w "\n"
    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(
                            @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        return  new ResponseEntity<String>("created employee payroll data for : "+
                employeePayrollDTO, HttpStatus.OK);
    }

    //curl -X PUT -H "Content-Type: application/json"
    //  -d '{"firstName" : "Padmaja", "salary" : "20000"}'
    //localhost:8080/employeepayrollservice/update -w "\n"
    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeePayrollData(
            @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        return  new ResponseEntity<String>("updated employee payroll data for : "+
                employeePayrollDTO, HttpStatus.OK);
    }

    @DeleteMapping("delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId")int empId) {
        return  new ResponseEntity<String>("Delete Call Success for id : "+empId, HttpStatus.OK);
    }
}
