package services;

import controllers.Products;
import data.DbProvider;
import models.Department;
import models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private int status;

    public ProductService() {
        this.connection = null;
        this.statement = null;
        this.resultSet = null;
        this.preparedStatement = null;
        this.status = 0;
    }

    public List<Product> getAllDeps () {
        List<Product> products = new ArrayList<Product>();
        try {
            connection = DbProvider.getMySQLConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from products order by id");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                var product = new Product(id, name);
                products.add(product);
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
        return products;
    }
}
