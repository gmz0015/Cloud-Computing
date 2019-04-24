package team06.platform.service;

import team06.platform.domain.Database;

import java.util.List;

public interface IDatabaseService {

    Database createDBbyId(String userid);

    Database queryDBbyid(String userid);

    List<Database> queryAllDBs();

    String changePassword(String username, String newPassword);

    String executeSQL(String SQL);
}
