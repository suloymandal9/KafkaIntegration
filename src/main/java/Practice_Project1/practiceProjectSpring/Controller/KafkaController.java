//step 2

package Practice_Project1.practiceProjectSpring.Controller;

import Practice_Project1.practiceProjectSpring.DTO.EmployeeEvent;
import Practice_Project1.practiceProjectSpring.Producer.EmployeeKafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
@RequiredArgsConstructor

public class KafkaController {

    private final EmployeeKafkaProducer employeeKafkaProducer;

    @PostMapping("/send")
    public String sendMessage(@RequestBody EmployeeEvent event) {

        employeeKafkaProducer.sendMessage(event);

        return "Employee Event sent successfully";
    }
}