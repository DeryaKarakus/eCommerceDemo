package DataAccess.abstracts;

import Entities.concretes.User;

import java.util.List;

public interface UserDao {

    void add(User user);
    void delete(User user);
    void update(User user);
    User get(int id);
    List<User> getAll();
    User getEmail(String mail);
}
