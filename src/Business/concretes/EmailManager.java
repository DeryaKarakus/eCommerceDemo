package Business.concretes;

import Business.abstracts.EmailService;

import java.util.Random;

public class EmailManager implements EmailService {

    int verificationCode;

    public EmailManager() {
        Random random = new Random();
        this.verificationCode = random.nextInt(1000)*10;
    }

    @Override
    public int emailSend() {
        return this.verificationCode;
    }
}
