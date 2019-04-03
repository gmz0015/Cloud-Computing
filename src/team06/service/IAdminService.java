package team06.service;

import team06.domain.Application;
import team06.domain.DBUser;
import team06.domain.Database;

import java.util.List;

public interface IAdminService {

    List<Database> queryAllDBs();

    List<Application> queryAllApps();

    List<DBUser> queryAllUsers();
}
