
package Practice_Project1.practiceProjectSpring.Consumer;

import Practice_Project1.practiceProjectSpring.DTO.EmployeeEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



@Service
public class EmployeeKafkaConsumer {

    @KafkaListener(
            topics = "employee-events",
            groupId = "employee-group"
    )
    public void consume(EmployeeEvent event) {

        System.out.println(
                "Received Employee Event: " + event
        );
    }
}