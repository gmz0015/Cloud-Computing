package team06.platform.service.impl;

import team06.platform.dao.IUserDao;
import team06.platform.dao.impl.UserDaoImpl;
import team06.platform.domain.User;
import team06.platform.service.IUserService;

public class UserServiceImpl implements IUserService {
    private IUserDao userDao = new UserDaoImpl();

    @Override
    public User login(String userName, String password) {
        return userDao.queryUserInfo(userName, password);
    }

    @Override
    public Boolean register(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public Boolean changePassword(String userId, String password) {
        return userDao.updateUserPassword(userId, password);
    }

    @Override
    public Boolean changeEmail(String userId, String email) {
        return userDao.updateUserEmail(userId, email);
    }

    @Override
    public Boolean changeAvatar(String userId, String avatar) {
        return userDao.updateUserAvatar(userId, avatar);
    }

    @Override
    public User getUserInfo(String userId) {
        return userDao.queryUserInfoById(userId);
    }
}
