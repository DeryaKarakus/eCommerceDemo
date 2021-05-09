package Business.concretes;

import Business.abstracts.EmailService;
import Business.abstracts.UserService;
import Business.abstracts.ValidationService;
import DataAccess.abstracts.UserDao;
import DataAccess.concretes.BaseUserDao;
import Entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager implements UserService {

    private UserDao userDao;
    private EmailService emailService;
    private ValidationService validationService;

    public UserManager(UserDao userDao, EmailService emailService, ValidationService validationService) {
        super();
        this.userDao = userDao;
        this.emailService = emailService;
        this.validationService = validationService;
    }

    List<User> users = new ArrayList<User>();
    public UserManager() {
        users.add((User) this.getAll());
    }


    public boolean userCheck(String mail){
        if (userDao.getEmail(mail) != null){
            System.out.println("User existing");
            return false;
        }
        return true;
    }


    @Override
    public void add(User user) {
        if (userCheck(user.getemail()) || validationService.validate(user)) {
            userDao.add(user);
            System.out.println("Your verification code has been sent by mail. Your verification code: " + emailService.emailSend());
            System.out.println("Enter verification code:");
            return;
        }
        System.out.println("Check user information!");
    }

    @Override
    public void delete(User user) {
        this.userDao.delete(user);
    }

    @Override
    public void update(User user) {
        this.userDao.update(user);
    }

    @Override
    public User get(int id) {
        User result=this.userDao.get(id);
        return result;
    }

    @Override
    public List<User> getAll() {
        List<User> result = this.userDao.getAll();
        return result;
    }

    @Override
    public void userVerify(User user, int verificationCode) {
        int result = emailService.emailSend();
        if (result == emailService.emailSend()) {
            System.out.println("User verified. Your membership completed" + user.getFirstName());
        }
        else {
            System.out.println("Your verification code is wrong");
        }

    }

}
