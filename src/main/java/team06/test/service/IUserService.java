package team06.test.service;

import team06.test.domain.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();

    User getUserByID(String userid);

    User getUserByUsername(String username);
}
