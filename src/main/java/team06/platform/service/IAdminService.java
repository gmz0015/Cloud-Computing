package team06.platform.service;

import team06.platform.domain.Application;
import team06.platform.domain.DBUser;
import team06.platform.domain.Database;

import java.util.List;

public interface IAdminService {

    List<Database> queryAllDBs();

    List<Application> queryAllApps();

    List<DBUser> queryAllUsers();
}
