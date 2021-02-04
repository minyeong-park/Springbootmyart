package io.playdata.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import io.playdata.model.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	

}
