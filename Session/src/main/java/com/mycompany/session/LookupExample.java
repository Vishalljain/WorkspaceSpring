/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.session;

/**
 *
 * @author IXL1KOR
 */
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;


// Service interface for adding numbers
interface AddService {
    void addNumber(int num);

   
}

// Service interface for calculating average
interface AvgService {
    double calculateAverage();
}

// Class A implementing AddService
class A implements AddService {
    private int sum = 0;
    private int count = 0;

    @Override
    public void addNumber(int num) {
        sum += num;
        count++;
    }

    public int getSum() {
        return sum;
    }

    public int getCount() {
        return count;
    }
}

// Class B implementing AvgService
class B implements AvgService {
    private A addService; // B depends on A to get the sum and count

    public B(A addService) {
        this.addService = addService;
    }

    @Override
    public double calculateAverage() {
        int sum = addService.getSum();
        int count = addService.getCount();

        return count > 0 ? (double) sum / count : 0.0;
    }
}

// Consumer module using Lookup
class Consumer {
    private InstanceContent content = new InstanceContent();
    private AbstractLookup lookup = new AbstractLookup(content);

    // Register services in the lookup
    public void registerService(Object service) {
        content.add(service);
    }

    // Use services from the lookup
    public void useServices() {
        // Look for services in the lookup
        AddService addService = lookup.lookup(AddService.class);
        AvgService avgService = lookup.lookup(AvgService.class);
        
//        note to understand it is downcasting converting to subclass A 
//        A a = ((A)addService);
//        a.getSum();
        // Use the services
        
        if (addService != null && avgService != null) {
            addService.addNumber(10);
            addService.addNumber(20);
            
            
          

            System.out.println("Sum: " + ((A) addService).getSum());
            System.out.println("Count: " + ((A) addService).getCount());
            System.out.println("Average: " + avgService.calculateAverage());
        } else {
            System.out.println("Services not found");
        }
    }
}

public class LookupExample {
    public static void main(String[] args) {
        // Create instances of A and B
        A addService = new A();
        B avgService = new B(addService);

        // Create an instance of the consumer
        Consumer consumer = new Consumer();

        // Register services in the consumer's lookup
        consumer.registerService(addService);
        consumer.registerService(avgService);

        // Use services from the consumer's lookup
        consumer.useServices();
    }
}

