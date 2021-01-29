/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Nurkholiq.latihanmvcjdbc.database;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import edu.Nurkholiq.latihanmvcjdbc.impl.PelangganDAOImpl;
import edu.Nurkholiq.latihanmvcjdbc.service.PelangganDAO;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Muhammad Nurkholiq
 */
public class KingsbarbershopDatabase {
    private static Connection connection;
    private static PelangganDAO pelangganDAO;
    
    public static Connection getConnection() throws SQLException{
        if (connection==null) {
        
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost:3306/kingsbarbershop");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
            
        
        }
    
        return connection;
    }
    public static PelangganDAO getPelangganDAO() throws SQLException{
        if (pelangganDAO==null){
            pelangganDAO = new PelangganDAOImpl(getConnection()) {};
        }
        return pelangganDAO;
    }
            
            
}
        

