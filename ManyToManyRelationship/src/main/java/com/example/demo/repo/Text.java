package com.example.demo.repo;

/*
public class Text {

Hibernate: create table course (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table student (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table student_course (student_id bigint not null, course_id bigint not null) engine=InnoDB
Hibernate: alter table student_course add constraint FKejrkh4gv8iqgmspsanaji90ws foreign key (course_id) references course (id)
Hibernate: alter table student_course add constraint FKq7yw2wg9wlt2cnj480hcdn6dq foreign key (student_id) references student (id)

So, in this case, three tables will be created: student, course, and student_course. The student_course table acts as an intermediary table to establish the many-to-many relationship between students and courses.

Each row in the student_course table represents a student enrolling in a course. This setup allows you to efficiently manage the many-to-many relationship between the two entities while avoiding data duplication and maintaining data integrity.

In the @JoinTable annotation with the @ManyToMany relationship configuration, the joinColumns attribute specifies the columns from the owning entity's table (the entity on which the @JoinTable is defined), and the inverseJoinColumns attribute specifies the columns from the target entity's table (the entity being joined).

In your example with the Student and Course entities, the joinColumns attribute specifies the columns from the student table, and the inverseJoinColumns attribute specifies the columns from the course table.

However, it might be a bit misleading since you have an id column in both the student and course tables. Here's how it works:
In this configuration, the student_id column is a foreign key in the student_course table that references the id column in the student table. Similarly, the course_id column in the student_course table is a foreign key that references the id column in the course table.

So, even though you have only an id column in the student and course tables, the student_id and course_id columns in the student_course table effectively reference these id columns to establish the many-to-many relationship.


mappedBy attribute:
The @ManyToMany association with the mappedBy attribute is used on the non-owning side of the relationship to indicate that the relationship is already mapped by the owning side. Let's break down the usage of mappedBy in a many-to-many relationship.

Consider the example you provided:


}
*/
