package com.tut;
/*
public class Text {

Get Method
Employee emp = (Employee) session.get(Employee.class, new Long(2));---This will hit db
Whenevr u call a get method for first time it will be hit the db then  the object is stored in session cache memory 
Employee emp = (Employee) session.get(Employee.class, new Long(2));----2nd time no hit
2nd time when u hit the api again with same id it will not hit the db again it will give the same object which is stored in cache

Employee emp = (Employee) session.get(Employee.class, new Long(2));
sout("q :"+emp.getName())
Employee emp2 = (Employee) session.get(Employee.class, new Long(2));
sout("w :"+emp2.getName())
u can see in console only one time select query is run and 2 output q:vis w:vis


2nd scenario
Whenevr u call a get method for first time it will be hit the db then  the object is stored in session cache memory
now u clear the session  so object is removed
2nd time when u hit the api again with same id it  hit the db again


Load Method:
Employee emp1 = (Employee) session.load(Employee.class, new Long(1));---This line will not hit db u just stored in a varaible
after above line exceuted That is it returns proxy object as it will not have any data dummy object
when u use this object at this time it will hit db  like getting emp1.name System.out.println("Employee load Details:: "+emp1.name+"\n");now it will hit that is lazy loading



}
*/
