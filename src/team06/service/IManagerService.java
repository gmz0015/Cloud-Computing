package team06.service;

import team06.domain.Application;

import java.sql.SQLException;

public interface IManagerService {

    int insertNewApp(Application application) throws SQLException;
}
