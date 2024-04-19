package org.example;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class DbHandler {
    private static final String DB_URL = "jdbc:sqlite:C:\\Users\\nik-d\\labs\\lab5.2\\Telephone.db";

    private static DbHandler instance = null;

    public static synchronized DbHandler getInstance() throws SQLException {
        if (instance == null)
            instance = new DbHandler();
        return instance;
    }

    private Connection connection;

    private DbHandler() throws SQLException {
        try {
            DriverManager.registerDriver(new JDBC());
            this.connection = DriverManager.getConnection(DB_URL);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        System.out.println("Opened database successfully");
    }

    public List<Client> getAllClients() {
        try (Statement statement = this.connection.createStatement()) {
            List<Client> clients = new ArrayList<Client>();
            ResultSet resultSet = statement
                    .executeQuery("Select idClient, name, surname, balance, spending FROM Client");
            while (resultSet.next()) {
                clients.add(new Client(resultSet.getInt("idClient"), resultSet.getString("name"),
                        resultSet.getString("surname"), resultSet.getInt("balance"), resultSet.getInt("spending")));
            }
            statement.close();

            return clients;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<Services> getAllServices() {
        try (Statement statement = this.connection.createStatement()) {
            List<Services> services = new ArrayList<Services>();
            ResultSet resultSet = statement
                    .executeQuery("Select idService, service_name, price, duration FROM Services");
            while (resultSet.next()) {
                services.add(new Services(resultSet.getInt("idService"), resultSet.getString("service_name"),
                        resultSet.getInt("price"), resultSet.getInt("duration")));
            }
            statement.close();

            return services;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<String[]> getBillsByOrderDate() {
        try (Statement statement = this.connection.createStatement()) {

            List<String[]> bills = new ArrayList<String[]>();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM bill ORDER BY order_date");

            while (resultSet.next()) {
                bills.add(new String[] { resultSet.getString("order_date"),
                        resultSet.getString("customer"),
                        resultSet.getString("customer_surname"),
                        resultSet.getString("product"),
                        resultSet.getString("cost") });
            }
            statement.close();
            return bills;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<String[]> getBillsBySurname() {
        try (Statement statement = this.connection.createStatement()) {
            List<String[]> bills = new ArrayList<String[]>();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM bill ORDER BY customer_surname");


            while (resultSet.next()) {
                bills.add(new String[] { resultSet.getString("order_date"),
                        resultSet.getString("customer"),
                        resultSet.getString("customer_surname"),
                        resultSet.getString("product"),
                        resultSet.getString("cost") });
            }
            statement.close();
            return bills;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public boolean changeServiceInOrders(int idService, int idClient) {
        try (Statement statement = this.connection.createStatement()) {

            statement.executeUpdate(String.format(
                    "UPDATE Orders SET idService = '%d' WHERE customer = '%d'", idService, idClient));
            statement.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (java.lang.NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean AddOrder( int idClient, int idService, String date_purchase, String status ){
        try (Statement statement = this.connection.createStatement()) {

            statement.executeUpdate(String.format(
                    "INSERT INTO Orders ( idClient, idService, date_purchase, status) VALUES ('%d','%d','%s','%s')",idClient, idService, date_purchase, status));
            statement.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (java.lang.NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addClient(Client client) {
        try (Statement statement = this.connection.createStatement()) {

            statement.executeUpdate(
                    String.format(
                            "INSERT INTO Client (idClient,name,surname,balance,spending ) VALUES  ('%d','%s','%s','%d','%d')",
                            client.id, client.name, client.surname, client.balance, client.spending));
            statement.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (java.lang.NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addService(Services services) {
        try (Statement statement = this.connection.createStatement()) {

            statement.executeUpdate(String.format(
                    "INSERT INTO Services (idService,service_name,price,duration ) VALUES  ('%d','%s','%d','%d')",
                    services.idService, services.service_name, services.price, services.duration));
            statement.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (java.lang.NullPointerException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean AddBalance(int balance, String name, String surname){
        try (Statement statement = this.connection.createStatement()) {

            statement.executeUpdate(String.format(
                    "UPDATE Client SET balance = '%d' WHERE name = '%s' AND surname = '%s'", balance, name, surname));
            statement.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (java.lang.NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

}
