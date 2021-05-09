package DataAccess.concretes;

import DataAccess.abstracts.UserDao;
import Entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class BaseUserDao implements UserDao {
    List<User> users = new ArrayList<User>();

    public BaseUserDao() {
        User user1 = new User(1,"Engin","Demiroğ","engin2@gmail.com","123456");
        User user2 = new User(2,"Derya","Karakuş","derya1@gmail.com","123886");
        users.add(user1);
        users.add(user2);

    }

    @Override
    public void add(User user) {
        System.out.println("User Added : " + user.getFirstName() +" "+user.getLastName());
        users.add(user);
    }

    @Override
    public void delete(User user) {
        System.out.println("User deleted : " + user.getFirstName()+" "+user.getLastName());
    }

    @Override
    public void update(User user) {
        System.out.println("User updated : " + user.getFirstName()+" "+user.getLastName());
    }

    @Override
    public User get(int id) {
        User user = users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
        System.out.println("User name : " + user.getFirstName());
        return user;
    }

    @Override
    public List<User> getAll() {
        for (User user : users) {
            System.out.println(user.getFirstName());
        }
        System.out.println("****************");
        return this.users;
    }

    @Override
    public User getEmail(String mail) {
        User user = users.stream().filter(u -> u.getemail() == mail).findFirst().orElse(null);
        return user;
    }
}
