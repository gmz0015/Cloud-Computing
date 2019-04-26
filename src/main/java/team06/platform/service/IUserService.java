package team06.platform.service;

import team06.platform.domain.User;

public interface IUserService {

    User login(String userName, String password);
}
