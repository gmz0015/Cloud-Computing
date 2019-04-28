package team06.platform.service;

import team06.platform.domain.User;

public interface IUserService {

    User login(String userName, String password);

    Boolean register(User user);

    Boolean changePassword(String userId, String password);

    Boolean changeEmail(String userId, String email);

    Boolean changeToDeveloper(String userId, String userName);

    Boolean changeAvatar(String userId, String avatar);

    User getUserInfo(String userId);
}
