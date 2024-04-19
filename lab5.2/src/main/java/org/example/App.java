package org.example;

import java.io.FileInputStream;
import java.io.IOException;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class App {
    static Logger LOGGER;
    static {
        try (FileInputStream ins = new FileInputStream(".\\log.config")) {
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(App.class.getName());

        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }

    static DbHandler dbHandler;
    static Scanner scanner = new Scanner(System.in);
    static boolean adminUserFlag;
    static String ADMIN_PSWD = "pswd";

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "App start");

        try {
            LOGGER.log(Level.INFO, "Connect to DB");
            dbHandler = DbHandler.getInstance();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Connection to DB failed");
            e.printStackTrace();
        }

        boolean work = true;
        while (true) {
            System.out.println("=========================================");
            System.out.println("||                Menu                 ||");
            System.out.println("=========================================");
            System.out.println("0. Bills by date\n" + //
                    "1. Bills by surname\n" +
                            "2. All Clients\n" +
                            "3. All services \n" +
                            "4. Get bills in csv format\n" +
                            "5.Admin authorization \n");
            System.out.println("-----------------------------------------");
            System.out.println("6 Add service \n" +
                            "7. Add client");
            System.out.println("8. Add date and status\n" +
                    "9. Change service");
            System.out.println("10. Add balance");
            System.out.println("-----------------------------------------");
            System.out.println("else. Exit");
            System.out.println("=========================================");
            System.out.print("Input: ");
            switch (scanner.nextLine()) {

                case "0":
                    LOGGER.log(Level.INFO, "Bills by date output request");
                    List<String[]> bills_by_date = Collections.emptyList();
                    bills_by_date = dbHandler.getBillsByOrderDate();
                    for (String[] bill : bills_by_date) {
                        System.out.println(Arrays.toString(bill));
                    }
                    break;

                case "1": {
                    LOGGER.log(Level.INFO, "Bills by surname output request");
                    List<String[]> bills_by_surname = Collections.emptyList();
                    bills_by_surname = dbHandler.getBillsBySurname();
                    for (String[] bill : bills_by_surname) {
                        System.out.println(Arrays.toString(bill));
                    }
                    break;
                }
                case "2": {
                    LOGGER.log(Level.INFO, "Clients output request");
                    List<Client> clients = dbHandler.getAllClients();
                    System.out.println("Show without sorting(1) or sort(2)?");
                    switch (scanner.nextLine()) {
                        case "1":
                            break;
                        case "2":
                            clients.sort(Client.SpendingComparator);
                            break;
                        default:
                            System.out.println("return to menu");
                            break;
                    }
                    for (Client client : clients) {
                        System.out.println(client.toString());
                    }
                    break;
                }
                case "3": {
                    LOGGER.log(Level.INFO, "Services output request");
                    List<Services> servicess = dbHandler.getAllServices();
                    for (Services services : servicess) {
                        System.out.println(services);
                    }
                    break;
                }
                case "4": {
                    LOGGER.log(Level.INFO, "Request for compiling a CSV report for bills");
                    List<String[]> bills = dbHandler.getBillsByOrderDate();
                    List<String> csvBills = new ArrayList<String>();
                    for (String[] recordsString : bills ) {
                        String csvString = Csv.convertToCsvString(recordsString[0],
                                recordsString[1],
                                recordsString[2],
                                recordsString[3],
                                recordsString[4]);
                        csvBills.add(csvString);

                    }
                    try {

                        Csv.writeStringsToCsv(csvBills);
                    } catch (IOException e) {
                        LOGGER.log(Level.WARNING, "Unable to write a csv file" + e.getMessage());

                    }
                    break;
                }
                case "5": {
                    LOGGER.log(Level.INFO, "Administrator authorization attempt");
                    System.out.println("Enter password");
                    adminUserFlag = adminAuthorization();
                    if (adminUserFlag) {
                        System.out.println("Successfully authorized");
                        LOGGER.log(Level.INFO, "Successfully authorizated");
                    }
                    break;
                }

                case "6": {
                    if (!adminUserFlag) {
                        System.out.println("You are not an admin");
                        break;
                    }

                    LOGGER.log(Level.INFO, "Add service to db");
                    System.out.println("Enter: Id");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter: service_name");
                    String service_name = scanner.nextLine();
                    System.out.println("Enter: price");
                    int price = scanner.nextInt();
                    System.out.println("Enter: duration");
                    int duration = scanner.nextInt();

                    Services services = new Services(id, service_name, price, duration);

                    if (!dbHandler.addService(services)) {
                        LOGGER.log(Level.WARNING, "Error occurred while adding services to DB");
                    }
                    break;
                }
                case "7": {
                    if (!adminUserFlag) {
                        System.out.println("You are not an admin");
                        break;
                    }

                    LOGGER.log(Level.INFO, "Add client to db");
                    System.out.println("Enter id ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter name ");
                    String name = scanner.nextLine();
                    System.out.println("Enter surname ");
                    String surname = scanner.nextLine();
                    System.out.println("Enter balance");
                    int balance = scanner.nextInt();
                    System.out.println("Enter spending ");
                    int spending = scanner.nextInt();

                    Client clients = new Client(id, name, surname, balance, spending);

                    if (!dbHandler.addClient(clients)) {
                        LOGGER.log(Level.WARNING, "Error occurred while adding clients to DB");
                    }
                    break;
                }
                case "8": {
                    if (!adminUserFlag) {
                        System.out.println("You are not an admin");
                        break;
                    }

                    LOGGER.log(Level.INFO, "Add bill to db");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD");


                    try {
                        System.out.println("Enter client id: ");
                        int idClient = scanner.nextInt();
                        System.out.println("Enter service id");
                        int idService = scanner.nextInt();
                        System.out.print("Enter date in format yyyy-MM-dd: ");
                        scanner.nextLine();
                        String date_purchase = scanner.nextLine();
                        dateFormat.parse(date_purchase);
                        System.out.println("Enter status");
                        String status = scanner.nextLine();
                        dbHandler.AddOrder(idClient, idService, date_purchase, status);
                        if (!dbHandler.AddOrder(idClient, idService, date_purchase, status)) {
                            LOGGER.log(Level.WARNING, "Error occurred while trying to add bill");
                        }
                        break;
                    } catch (ParseException e) {
                        System.out.println("Error in date format");
                    }
                }
                case "9": {
                    if (!adminUserFlag) {
                        System.out.println("You are not an admin");
                        break;
                    }

                    LOGGER.log(Level.INFO, "Change service in orders");

                    System.out.println("Enter: id of client and new service id");
                    int idService = scanner.nextInt();
                    int idClient = scanner.nextInt();
                    dbHandler.changeServiceInOrders(idService, idClient);
                    if (!dbHandler.changeServiceInOrders(idService, idClient)) {
                        LOGGER.log(Level.WARNING, "Error occurred while trying to change bill");
                    }
                }
                case "10":{
                    if (!adminUserFlag) {
                        System.out.println("You are not an admin");
                        break;
                    }

                    LOGGER.log(Level.INFO, "Add balance");

                    System.out.println("Enter: balance and who to send it to");
                    System.out.println("Enter balance");
                    int balance = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter name");
                    String name = scanner.nextLine();
                    System.out.println("Enter surname");
                    String surname = scanner.nextLine();
                    dbHandler.AddBalance(balance, name, surname);
                    if (!dbHandler.AddBalance(balance, name, surname)) {
                        LOGGER.log(Level.WARNING, "Error occurred while trying to add balance");
                        System.out.println("Error occurred while trying to add balance");
                    }
                }

            }

        }

    }

    private static boolean adminAuthorization() {

        String password = scanner.nextLine();

        return password.equals(ADMIN_PSWD);
    }
}
