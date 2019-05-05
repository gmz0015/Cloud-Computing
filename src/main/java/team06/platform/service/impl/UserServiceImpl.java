package team06.platform.service.impl;

import team06.platform.dao.IAccountDao;
import team06.platform.dao.IUserDao;
import team06.platform.dao.impl.AccountDaoImpl;
import team06.platform.dao.impl.UserDaoImpl;
import team06.platform.domain.Database;
import team06.platform.domain.User;
import team06.platform.service.IDatabaseService;
import team06.platform.service.IUserService;

import java.io.File;

public class UserServiceImpl implements IUserService {
    private IUserDao userDao = new UserDaoImpl();
    private IDatabaseService databaseService = new DatabaseServiceImpl();
    private IAccountDao accountDao = new AccountDaoImpl();

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
    public Boolean changeToDeveloper(String userId, String userName) {
        Database database = databaseService.createDBbyId(userId, userName);
        if ((database == null) || !userDao.updateUserRole(userId, userName, "DEVELOPER")) {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public Boolean changeAvatar(String userId, String avatar, String savePath) {
        String avatarName = userDao.queryUserInfoById(userId).getAvatar();
        if (avatarName.equals("avatar.jpg")) {
            return userDao.updateUserAvatar(userId, avatar);
        }else {
            String oldAvatarPath = savePath + "/" + avatarName;
            File file = new File(oldAvatarPath);
            if (file.exists() && file.isFile()) {
                if (file.delete()) {
                    return userDao.updateUserAvatar(userId, avatar);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    @Override
    public User getUserInfo(String userId) {
        return userDao.queryUserInfoById(userId);
    }

    @Override
    public Boolean logout(Long userId) {
        return accountDao.deleteCharge(userId);
    }
}
