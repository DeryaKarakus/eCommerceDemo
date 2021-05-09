package Business.abstracts;

import Entities.concretes.User;

public interface ValidationService {
    boolean validate(User user);
    boolean login(User user);
}
