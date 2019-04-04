package team06.test.service.impl;

import team06.test.dao.IUserDao;
import team06.test.dao.impl.UserDaoImpl;
import team06.test.domain.User;
import team06.test.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
    private IUserDao userDao = new UserDaoImpl();

    @Override
    public List<User> getAllUsers() {
        return userDao.queryAllUsers();
    }

    @Override
    public User getUserByID(String userid) {
        return userDao.queryUserByID(userid);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.queryUserByUsername(username);
    }

}
