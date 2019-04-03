package team06.service;

import team06.domain.Database;

import java.util.List;

public interface IDatabaseService {

    Database queryDBbyid(int userid);

    List<Database> queryAllDBs();
}
