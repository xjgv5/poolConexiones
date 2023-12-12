package com.xjgv.javaJDBC.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=Mexico/General";
    private static String username = "root";
    private static String password = "admin";
    private static BasicDataSource pool;

    public static BasicDataSource getInstance() throws SQLException {
        if (pool == null){
            //conexion = DriverManager.getConnection(url, username, password);
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(username);
            pool.setPassword(password);
            pool.setInitialSize(3); //tamaño inicial del pool
            pool.setMinIdle(3); //tamaño minimo de conexiones activas
            pool.setMaxIdle(8); //tamaño maximo de conexiones activas
            pool.setMaxTotal(8); //tamaño maximo de sesiones activas y no activas
        }

        return pool;
    }

    public static Connection getConection() throws SQLException {
        return getInstance().getConnection();
    }

}
