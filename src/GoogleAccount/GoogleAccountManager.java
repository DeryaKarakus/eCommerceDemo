package GoogleAccount;

import Entities.concretes.User;

public class GoogleAccountManager {
    public boolean manager(int id,String firstName,String lastName,String email,String password){
        if (firstName.length() > 5 && lastName.length() > 5 && email.length() > 5 && password.length() > 5) {
            return true;
        }
        return false;
    }

}
