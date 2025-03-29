import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/alerts")
public class AlertController {
    @GetMapping("/test")
    public ResponseEntity<String> testAlert() {
        return ResponseEntity.ok("Alert system working!");
    }
}
