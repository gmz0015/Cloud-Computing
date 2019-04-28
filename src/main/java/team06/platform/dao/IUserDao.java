package team06.platform.dao;

import team06.platform.domain.User;

public interface IUserDao {

    Boolean insertUser(User user);

    User queryUserInfoByName(String userName);

    User queryUserInfoById(String userId);

    User queryUserInfo(String userName, String password);

    Boolean updateUserPassword(String userId, String password);

    Boolean updateUserEmail(String userId, String email);

    Boolean updateUserAvatar(String userId, String avatarPath);

    Boolean updateUserRole(String userId, String userName, String role);
}
