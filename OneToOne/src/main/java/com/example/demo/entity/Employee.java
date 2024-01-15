package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="employee_details")

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emp_id")
	private Long empid;
	private String empName;
	private Integer empAge;
	//by default spring boot will create foreign key as address_add_id that is tablename+id column name
	@OneToOne(cascade = CascadeType.ALL)
	//we can create custom fk
	@JoinColumn(name="fk_add_id")
	private Address address;
	
	
	

}
