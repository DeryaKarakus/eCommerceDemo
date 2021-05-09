import Business.abstracts.UserService;
import Business.abstracts.ValidationService;
import Business.concretes.EmailManager;
import Business.concretes.UserManager;
import Business.concretes.ValidationManager;
import Core.GoogleAccountAdapter;
import DataAccess.concretes.BaseUserDao;
import Entities.concretes.User;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ValidationService googleAccountAdapter = new GoogleAccountAdapter();

        User user = new User();
        user.setId(3);
        user.setFirstName("Ali");
        user.setLastName("Babis");
        user.setemail("alibabis@gmail.com");
        user.setPassword("ali23421");

        User user2 = new User();
        user2.setId(4);
        user2.setFirstName("Emre");
        user2.setLastName("Babis");
        user2.setemail("emrebabis@gmail.com");
        user2.setPassword("120wf78");

        UserService userService = new UserManager(new BaseUserDao(), new EmailManager(), new ValidationManager());
        userService.getAll();
        userService.add(user);

        int verificationCode = scanner.nextInt();
        userService.userVerify(user,verificationCode);

        userService.add(user2);



    }
}
