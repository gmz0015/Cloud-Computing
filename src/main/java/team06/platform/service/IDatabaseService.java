package team06.platform.service;

import team06.platform.domain.Database;

import java.util.List;

public interface IDatabaseService {

    Database createDBbyId(String userId);

    Database queryDBbyid(String userId);

    List<Database> queryAllDBs();

    String changePassword(String userName, String newPassword);

    String executeSQL(String SQL);
}
