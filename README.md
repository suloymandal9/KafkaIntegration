# Kafka Project 
## 1.Add Spring Kafka

I added the Spring for Apache Kafka dependency to my Spring Boot application.

Why?
It provides Spring integration with Kafka, including KafkaTemplate for producing messages and @KafkaListener for consuming messages.

## 2.Run Kafka using Docker

I used Docker to run Kafka locally instead of installing Kafka directly on my machine.

Why?
Docker makes it easier to start, stop and manage Kafka.

Kafka is running on:

localhost:9092


## 3.Create Kafka Topic

I created a topic called:

employee-events

with 2 partitions.

Topic: A topic is a logical category where Kafka stores messages.

Partition: A topic can be divided into multiple partitions for scalability and parallel processing.

## 4.Configure Kafka Producer

I configured Spring Boot with the Kafka broker address:

localhost:9092

Then I used KafkaTemplate to send messages to Kafka.

Producer: A producer is responsible for publishing messages/events to a Kafka topic.

## 5.Integrate REST API with Kafka

I created a REST API through which the client sends employee information.

The flow is:

REST API
   ↓
Spring Boot
   ↓
Kafka Producer
   ↓
Kafka Topic


## 6.Create Employee Event

Instead of sending simple strings, I created an EmployeeEvent Java object containing:

employeeId
name
department

For example:

{
  "employeeId": 101,
  "name": "Rahul",
  "department": "IT"
}

This represents the event that needs to be published to Kafka.


## 7.JSON Serialization

I configured JacksonJsonSerializer.

Serialization means converting a Java object into a format that can be sent through Kafka.

EmployeeEvent
      ↓
JSON Serialization
      ↓
Kafka

So the overall producer-side flow is:

Client
  ↓
REST API
  ↓
EmployeeEvent
  ↓
KafkaTemplate
  ↓
JSON Serialization
  ↓
Kafka Topic
