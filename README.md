# rollingstone-ecommerce-spring-boot-verbose-debug-aid

This multiple applications in this repository is added to demonstrate a debug aid called verbose. 

## Purpose : A number of applications have to call other downstream third party internal / external APIs to get data from legacy systems. 
A very typical patterns can been seen in client JAvaScript applications, that has a proxy / API gateway type of backend. This backend talks
to the numerous other third party internal / external APIs, on behalf of the front end application. As the front end application only know this 
API gateway backend, debugging this pair app of front end / API gateway backend sometimes becomes very cumbersome without special tools. 

Following is a typical scnerio when one or more production issues are reported for these pair of  front end / API gateway backend applications

##1. Customers complain and call the customer Support

##2. Tech Support log support request with 24/7 Tech Support

##3. Tech Support fails to resolve the issue

##4. Tech support reach out to Dev Team and create a ticket in the Ticketing system i.e. SericeThen or (now)

##5. Dev Team Manager gets notified by the Tech Support through Email / Self checks.

##6. Dev Team manager own ticket and asigns the ticket to a Developer

##7. The Developer looks at the request and searches either Splunk Logs / ELK Logs to retreive past log data, hoping the incident took
place within the last so many days so logs are available

##8. Logs do not help much as production logs do not have contain debug messages and the Developer starts to debug manually retreiving 
userdata.

##9. Step number 9 takes time......, email chains between different systems / applications, onshore / offshore and other shores.

##10. If this happens with a critical API where the system / company is actually losing money by the hour, developers spend hours / days to fix and 
the company still looses huge sums.

#Alternative

##1. During design / development think about this kind of situations and add tools / aids that might instantly help pin point
the error and if that error is coming from a downsteam system, fixing effort can quickly be routed to that system.

##2. How this works is by adding an optional verbose parameter to REST APIs. With that verbose parameter present, APIs will respond normally 
but include raw responses from other APIs they called helping instant debugging of which system is responsible for the error. This repository demonstrates 
that situation with a few APIs.

