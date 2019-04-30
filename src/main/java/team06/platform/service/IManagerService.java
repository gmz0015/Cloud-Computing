package team06.platform.service;

import team06.platform.domain.Application;

import java.sql.SQLException;

public interface IManagerService {

    int insertNewApp(Application application, String UUID) throws SQLException;
}
