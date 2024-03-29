package services;

import data.DbProvider;
import models.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepsService {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private int status;

    public DepsService() {
        this.connection = null;
        this.statement = null;
        this.resultSet = null;
        this.preparedStatement = null;
        this.status = 0;
    }

    public List<Department> getAllDeps () {
        List<Department> departments = new ArrayList<Department>();
        try {
            connection = DbProvider.getMySQLConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from departments order by id");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                var dep = new Department(id, name);
                departments.add(dep);
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFound Exception" + ex.getMessage());
        }
        catch (SQLException ex) {
            System.out.println("Runtime SQLException" + ex.getMessage());
        }
        finally {
            try {
                if(resultSet != null) {
                    resultSet.close();
                }
                if(statement != null) {
                    statement.close();
                }
                if(connection != null) {
                    connection.close();
                }
            }
            catch (SQLException ex) {
                System.out.println("Final SQLException" + ex.getMessage());
            }
        }
        return departments;
    }
}
