package team06.test.dao;

import team06.test.domain.User;

import java.util.List;

public interface IUserDao {

    List<User> queryAllUsers();

    User queryUserByID(String userid);

    User queryUserByUsername(String username);
}
