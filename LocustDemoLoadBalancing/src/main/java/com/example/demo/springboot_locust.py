from locust import HttpUser, task, between #this is self-explanatory we importing required classes, function from locust module.

class SpringBootUser(HttpUser): #Simulates a single Real-world User. HttpUser class is extended so we provide what task the user will do.

    '''this won't take effect in our scenario, as this attribute is optional and specify wait time randomly picked between parameters passed (1-3 seconds) between multiple @task executed. We have only one @task executed'''
    wait_time = between(1, 3) 

    '''This is main core functionality of locust. @task are treated as a singel http request made. 
    We can multiple have @task. In below we are going to hit /greet endpoint on our localhost'''
    @task
    def hello_world(self):
        self.client.get("/greet")
        
 '''
 //To run this file use locust -f springboot_locust.py

//https://virendraoswal.com/locust-code-construct-based-load-testing

Requests: Number of requests made to the endpoint during the load test.
Fails: Number of requests that failed (returned an error status code) during the load test.
Median (ms): Median response time (in milliseconds) of all successful requests.
90%ile (ms): 90th percentile of response times, meaning 90% of all successful requests had a response time equal to or lower than this value.
99%ile (ms): 99th percentile of response times, meaning 99% of all successful requests had a response time equal to or lower than this value.
Average (ms): Average response time of all successful requests.
Min (ms): Minimum response time of all successful requests.
Max (ms): Maximum response time of all successful requests.
Average size (bytes): Average response size (in bytes) of all successful requests.
Current RPS: Current requests per second being made to the endpoint.
Current Failures/s: Current failures per second being encountered while making requests to the endpoint.

'''

