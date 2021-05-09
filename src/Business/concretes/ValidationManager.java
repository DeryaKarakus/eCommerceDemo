package Business.concretes;

import Business.abstracts.ValidationService;
import Core.LoginRules;
import Entities.concretes.User;

import java.util.regex.Pattern;

public class ValidationManager implements ValidationService {

    public static final Pattern  VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$\"",Pattern.CASE_INSENSITIVE);


    @Override
    public boolean validate(User user) {
        boolean result = LoginRules.run(passwordCheck(user),firstNameCheck(user),lastNameCheck(user),emailCheck(user));

        return result;
    }

    private boolean passwordCheck(User user) {
        if (user.getPassword().length() < 6) {
            System.out.println("The password must be at least 6 characters");
            return false;
        }
        return true;
    }

    private boolean firstNameCheck(User user) {
        if (user.getFirstName().length() < 2) {
            System.out.println("The name must have at least 2 characters");
            return false;
        }
        return true;
    }

    private boolean lastNameCheck(User user) {
        if (user.getFirstName().length() < 2) {
            System.out.println("The name must have at least 2 characters");
            return false;
        }
        return true;
    }

    private boolean emailCheck(User email) {
        return VALID_EMAIL_ADDRESS_REGEX.matcher(email.getemail()).find();
    }

    @Override
    public boolean login(User user) {
        boolean result = LoginRules.run(firstLastNameEmpty(user));
        return result;
    }
    private boolean firstLastNameEmpty(User user) {
        if (user.getemail().equals(null) || user.getPassword().equals(null)) {

            System.out.println("Username or password is missing");
            return false;
        }
        System.out.println("Login to the system");
        return true;
    }
}
