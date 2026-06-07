/* 
package org.proyecto_zoo_1dam.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:sqlite:database/proyecto_zoo.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}*/
package org.proyecto_zoo_1dam.database;

import java.io.IOException;
import java.nio.file.*;
import java.sql.*;

public class DatabaseConnection {
    private static final String DB_DIR = "database";
    private static final String DB_FILE = "proyecto_zoo.db";
    private static final String URL = "jdbc:sqlite:" + DB_DIR + "/" + DB_FILE;

    static {
        ensureDatabase();
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    private static void ensureDatabase() {
        try {
            Path dbPath = Paths.get(DB_DIR, DB_FILE);
            if (Files.size(dbPath) == 0) {
                try (Connection c = DriverManager.getConnection(URL)) {
                    String sql = Files.readString(Paths.get(DB_DIR, "crear_db.sql"));
                    for (String stmt : sql.split(";")) {
                        String s = stmt.trim();
                        if (!s.isEmpty()) {
                            try (Statement st = c.createStatement()) {
                                st.execute(s);
                            }
                        }
                    }
                }
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException("Error inicializando la BD", e);
        }
    }
}