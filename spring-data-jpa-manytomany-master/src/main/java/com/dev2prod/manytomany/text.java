package com.dev2prod.manytomany;

/*
public class text {

}

POST:
http://localhost:9111/employee/save
{
    "empName":"Bob"
}
http://localhost:9111/employee/save
{
    "empName":"John"
}

GET:
[
    {
        "empId": 1,
        "empName": "John",
        "assignedProjects": []
    },
    {
        "empId": 2,
        "empName": "Bob",
        "assignedProjects": []
    }
]

POST:
http://localhost:9111/project/save

{
    "projectName":"JavaProject"
}
{
    "projectName":"PythonProject"
}

GET://eMPLOYEEsET IS IGNORED SEE CODE
http://localhost:9111/project/getProjects
[
    {
        "projectId": 3,
        "projectName": "JavaProject"
    },
    {
        "projectId": 4,
        "projectName": "PythonProject"
    }
]



put:http://localhost:9111/employee/1/project/3-----not added any body direct hit the url it gave response

{
    "empId": 1,
    "empName": "John",
    "assignedProjects": [
        {
            "projectId": 3,
            "projectName": "JavaProject"
        }
    ]
}

After that i get employees--http://localhost:9111/employee/getEmployees

[
    {
        "empId": 1,
        "empName": "John",
        "assignedProjects": [
            {
                "projectId": 3,
                "projectName": "JavaProject"
            }
        ]
    },
    {
        "empId": 2,
        "empName": "Bob",
        "assignedProjects": []
    }
]






select * from employee_project;
employee_id project_id
1				3

select * from project;
project_id			project_name
3					javaproject
4					pythonproject

select * from employee;

	emp_id	emp_name
	1		John
	2		Bob
	
		
		
Determining where to use CascadeType in your JPA (Java Persistence API) relationships depends on how you want to manage the lifecycle of related entities. It's important to carefully consider the implications of cascading operations and choose the appropriate cascade types based on your application's requirements. Here's a guideline to help you determine where to use CascadeType:

Relationship Types:

Parent-Child Relationship (One-to-Many, Many-to-One): If you have a parent entity that owns a collection of child entities, consider using cascading operations from parent to child. This way, actions performed on the parent (such as saving or deleting) are automatically propagated to the child entities.

Owner-Referenced Relationship (One-to-One, Many-to-Many): If the related entities are not tightly coupled in terms of ownership (e.g., one entity references another but doesn't own it), cascading might not be as necessary or might even be inappropriate.
*/