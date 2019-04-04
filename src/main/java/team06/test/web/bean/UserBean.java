package team06.test.web.bean;

import team06.test.domain.User;
import team06.test.service.IUserService;
import team06.test.service.impl.UserServiceImpl;

import java.io.Serializable;
import java.util.List;

public class UserBean implements Serializable {
    private IUserService userService = new UserServiceImpl();

    public List<User> getAllUsers() { return userService.getAllUsers(); }

    public User getUserByID(String userid) { return userService.getUserByID(userid); }
}
