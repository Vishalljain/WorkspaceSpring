package com.example.demo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.example.demo.entity.Address;

public class Text {
	
	/*
	 * 
	 * how we know employee is a owning side : whenever you have onetoone mapping and used join column then it is owning side
	 * 
	 * 
	 * In a one-to-one relationship, where you have an Employee entity with
	 * an @OneToOne association to an Address entity, the placement of the foreign
	 * key depends on the design you choose. In your case, you've
	 * used @JoinColumn(name = "fk_add_id") on the address field in the Employee
	 * entity. This indicates that the foreign key column will be created in the
	 * Employee table, referencing the primary key (id) of the Address table.
	 * 
	 * InOneToMany, the foreign key istypically created on the "many" side of the relationship, which is the
	 * Product table. The @JoinColumn annotation specifies the foreign key column
	

	POST:http://localhost:9111/saveEmployee/
	
	[
    {
        "empName":"Mohit",
        "empAge":28,
        "address":
        {
            "city":"pune",
            "addressType":"Current"
        }
    },
     {
        "empName":"Chauhan",
        "empAge":29,
        "address":
        {
            "city":"Thane",
            "addressType":"Current"
        }
    }
]

select * from  onetoone.address;
  add_id	address_type	city
	2		Current	 		pune
	4		Current	 		Thane

select * from  onetoone.employee_details;
	emp_id	emp_age emp_name	fk_add_id
	1		28		Mohit		2
	3		29		Chauhan		4
	
	
	
	
	
	for oneToMany for same example the changes will be 
	
	public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emp_id")
	private Long empid;
	private String empName;
	private Integer empAge;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_emp_id",referenceColumnName="emp_id")
	private List<Address> address;---in address table we have fk_emp_id
	
	
	

}
	
	 */
	
}
