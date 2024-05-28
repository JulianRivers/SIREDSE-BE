package BackendSiadseUfps.siadse.service.implementations;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SMSService {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String fromNumber;

    public SMSService() {
        Twilio.init(accountSid, authToken);
    }

    public void sendSMS(String to, String body) {
        Message.creator(new PhoneNumber(to), new PhoneNumber(fromNumber), body).create();
    }
}
