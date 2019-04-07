package team06.service;

import team06.domain.Database;

import java.util.List;

public interface IDatabaseService {

    Database createDBbyId(String userid);

    Database queryDBbyid(String userid);

    List<Database> queryAllDBs();
}
