package com.example.demo;


/*
public class text {

}
POST:http://localhost:9111/placeOrder
{
    "customer":{
        "name":"Basant",
        "email":"b@gmail",
        "gender":"male",
        "products":[
            {
                "pid":201,
                "productName":"Mobile",
                "price":10000,
                "qty":1
            },
            {
                 "pid":202,
                "productName":"Laptop",
                "price":10000,
                "qty":1

            }
        ]
    }
}


RESPONSE:
{
    "id": 1,
    "name": "Basant",
    "email": "b@gmail",
    "gender": "male",
    "products": [
        {
            "pid": 201,
            "productName": "Mobile",
            "qty": 1,
            "price": 10000
        },
        {
            "pid": 202,
            "productName": "Laptop",
            "qty": 1,
            "price": 10000
        }
    ]
}

Added one more record with id 2
select * from  onetomany.customer;
	id	email	gender	name
	1	b@gmail	male	Basant
	2	v@gmail	male    vishal
select * from  onetomany.product;
pid price productnme qty cp_fk
201	10000	Mobile	 1	  1
202	10000	Laptop	 1	  1
203	10000	FAN		 1	  2	
204 10000	LIGHT    1    2


GET:
[
    {
        "id": 1,
        "name": "Basant",
        "email": "b@gmail",
        "gender": "male",
        "products": [
            {
                "pid": 201,
                "productName": "Mobile",
                "qty": 1,
                "price": 10000
            },
            {
                "pid": 202,
                "productName": "Laptop",
                "qty": 1,
                "price": 10000
            }
        ]
    },
    {
        "id": 2,
        "name": "Vishal",
        "email": "v@gmail",
        "gender": "male",
        "products": [
            {
                "pid": 203,
                "productName": "FAN",
                "qty": 1,
                "price": 10000
            },
            {
                "pid": 204,
                "productName": "LIGHT",
                "qty": 1,
                "price": 10000
            }
        ]
    }
]

GET : http://localhost:9111/getInfo/


[
    {
        "name": "Basant",
        "productName": "Mobile"
    },
    {
        "name": "Basant",
        "productName": "Laptop"
    },
    {
        "name": "Vishal",
        "productName": "FAN"
    },
    {
        "name": "Vishal",
        "productName": "LIGHT"
    }
]


Delete : http://localhost:9111/delete/1
aFTER DEELETING 
select * from  onetomany.customer;
	id	email	gender	name
	2	v@gmail	male    vishal
select * from  onetomany.product;
pid price productnme qty cp_fk
203	10000	FAN		 1	  2	
204 10000	LIGHT    1    2



*/
