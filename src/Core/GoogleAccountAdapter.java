package Core;

import Business.abstracts.ValidationService;
import Entities.concretes.User;
import GoogleAccount.GoogleAccountManager;

public class GoogleAccountAdapter implements ValidationService {

    GoogleAccountManager googleAccountManager = new GoogleAccountManager();

    @Override
    public boolean validate(User user) {
        boolean result = false;
        result = googleAccountManager.manager(user.getId(), user.getFirstName(), user.getLastName(), user.getemail(), user.getPassword());
        if (result != true) {
            return false;
        }
        System.out.println("Registered with google account");
        return true;
    }

    @Override
    public boolean login(User user) {
        boolean result = LoginRules.run(firstLastNameEmpty(user));
        return result;
    }
    private boolean firstLastNameEmpty(User user) {
        if (user.getemail() == null || user.getPassword()==null ) {
            System.out.println("Username or password is missing");
            return false;
        }
        System.out.println("Logged into the system");
        return true;
    }
}
