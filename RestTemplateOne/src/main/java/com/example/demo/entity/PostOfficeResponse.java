package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "post_office_response")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostOfficeResponse {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @Column(name = "message")
	    private String message;

	    @Column(name = "status")
	    private String status;

	    @OneToMany(cascade = CascadeType.ALL)
	    @JoinColumn(name = "post_office_response_id")
	    private List<PostOffice> postOfficeList;

}

/*
 //query generated during run 
Hibernate: 
    
    create table post_office (
       id bigint not null auto_increment,
        branch_type varchar(255),
        description varchar(255),
        name varchar(255),
        post_office_response_id bigint,
        primary key (id)
    ) engine=InnoDB
Hibernate: 
    
    create table post_office_response (
       id bigint not null auto_increment,
        message varchar(255),
        status varchar(255),
        primary key (id)
    ) engine=InnoDB
Hibernate: 
    
    alter table post_office 
       add constraint FK6ym13uvp2pqlx7l74qiien9qb 
       foreign key (post_office_response_id) 
       references post_office_response (id)

*/
