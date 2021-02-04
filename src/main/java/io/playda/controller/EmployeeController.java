package io.playda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.playdata.dao.EmployeeRepository;
import io.playdata.exception.EmployeeNotFoundException;
import io.playdata.model.domain.Employee;

@RestController
class EmployeeController {
	
	@Autowired
  private EmployeeRepository repository;

  EmployeeController(EmployeeRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/employees")
  List<Employee> all() {
    return repository.findAll();
  }

  @PostMapping("/newemployees")
  Employee newEmployee(@RequestBody Employee newEmployee) {
    return repository.save(newEmployee);
  }

  // Single item

  @GetMapping("/employees/{id}")
  Employee one(@PathVariable Long id) {

    return repository.findById(id)
      .orElseThrow(() -> new EmployeeNotFoundException(id));
  }

  @PutMapping("/employees/{id}")
  Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

    return repository.findById(id)
      .map(employee -> {
        employee.setName(newEmployee.getName());
        employee.setRole(newEmployee.getRole());
        return repository.save(employee);
      })
      .orElseGet(() -> {
        newEmployee.setId(id);
        return repository.save(newEmployee);
      });
  }
  //HATEOAS
//  @GetMapping("/employees/{id}")
//  EntityModel<Employee> one1(@PathVariable Long id) {
//
//    Employee employee = repository.findById(id) //
//        .orElseThrow(() -> new EmployeeNotFoundException(id));
//
//    return EntityModel.of(employee, //
//        linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel(),
//        linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
//  }

  @DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
    
    
  }
}