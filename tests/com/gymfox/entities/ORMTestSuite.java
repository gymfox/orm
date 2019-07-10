package com.gymfox.entities;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import static org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({AddDataToDatabaseTest.class,
        com.gymfox.entities.AssertDataFromDatabaseTest.class,
        com.gymfox.entities.DeleteDataFromDatabaseTest.class,
        com.gymfox.entities.EntityTest.class})
public class ORMTestSuite {
    static DBManagerImpl dbManager;
    static final int FIRST_INDEX = 1;

    @BeforeClass
    public static void setUpConnection() throws SQLException, ClassNotFoundException, FileNotFoundException {
        dbManager = new DBManagerImpl("newDatabaseTest");
        dbManager.initDatabase();
        dbManager.importSQL(new File("schema/schema.sql"));

        System.out.println("Database has been created.");
    }

    @AfterClass
    public static void tearDownConnection() throws SQLException {
        dbManager.dropDatabase();

        System.out.println("Database has been dropped.");
    }
}
