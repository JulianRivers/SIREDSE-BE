package BackendSiadseUfps.siadse.controller;

import BackendSiadseUfps.siadse.service.implementations.EmailService;
import BackendSiadseUfps.siadse.service.implementations.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private SMSService smsService;

    @PostMapping("/email")
    public void sendEmailNotification(@RequestParam String to, @RequestParam String subject, @RequestParam String body) {
        emailService.sendEmail(to, subject, body);
    }

    @PostMapping("/sms")
    public void sendSMSNotification(@RequestParam String to, @RequestParam String body) {
        smsService.sendSMS(to, body);
    }
}
