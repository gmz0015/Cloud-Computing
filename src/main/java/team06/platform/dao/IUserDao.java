package team06.platform.dao;

import team06.platform.domain.User;

public interface IUserDao {

    Boolean insertUser(User user);

    User queryUserInfoByName(String userName);

    User queryUserInfo(String userName, String password);
}
