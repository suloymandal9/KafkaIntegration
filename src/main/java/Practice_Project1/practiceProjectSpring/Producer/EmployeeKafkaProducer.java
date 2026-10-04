//package Practice_Project1.practiceProjectSpring.Producer;
//
//public class EmployeeKafkaProducer {
//}

// EmployeeKafkaProducer(s1)---> KafkaController(s2) ---> EmployeeEvent (s3) ---> add StringSerializer and
// JsonSerializer in application.properties


package Practice_Project1.practiceProjectSpring.Producer;

import Practice_Project1.practiceProjectSpring.DTO.EmployeeEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeKafkaProducer {

    private final KafkaTemplate<String, EmployeeEvent> kafkaTemplate;

//    Spring Kafka sends the EmployeeEvent to that existing
//    topic inside your Docker Kafka broker.
//Spring Kafka sends the EmployeeEvent to that existing topic(employee-events)
// inside your Docker Kafka broker.

//Docker container
//└── Kafka
//    └── employee-events
//        ├── Partition 0
//        └── Partition 1
    private static final String TOPIC = "employee-events";


    public void sendMessage(EmployeeEvent event) {

        kafkaTemplate.send(TOPIC, event);

        System.out.println(
                "Employee event sent: " + event
        );
    }
}