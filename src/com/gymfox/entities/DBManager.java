package com.gymfox.entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public interface DBManager {
    void initDatabase() throws ClassNotFoundException, SQLException;
    void importSQL(File in) throws SQLException, FileNotFoundException;
    void dropDatabase() throws SQLException;
    String getPreparedStatement(String query, int id) throws SQLException;
}
