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
}
