package io.playdata.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Employee {

  private @Id @GeneratedValue Long id;
  private String name;
  private String role;
  
  public Employee(String name, String role){
	  this.name = name;
	  this.role = role;
  }
}
