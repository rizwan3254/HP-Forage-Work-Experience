package com.example.restservice;
  
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.Employees;
import com.example.restservice.EmployeeManager;
  
// Creating the REST controller
@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
  
    @Autowired
    private EmployeeManager employeeManager;

    @GetMapping(path = "/", produces = "application/json")
    public Employees getEmployees()
    {
        return employeeManager.getAllEmployees();
    }

    @PostMapping("/employees")
	// We need to specify the @RequestBody annotation along with the `Coffee`
	// class as the argument. The decoded JSON body is then stored in the `coffee` argument
	// variable
	public String createCoffee(@RequestBody Employee employee) {
		// We can return a plaintext response with the string representation of the coffee
		// argument
		return "Created employee: " + employee.toString();
	}

}