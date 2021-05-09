package Business.abstracts;

import Entities.concretes.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void delete(User user);
    void update(User user);
    User get(int id);
    List<User> getAll();
    void userVerify(User user,int verificationCode);
}
