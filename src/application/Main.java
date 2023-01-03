package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter cliente data:");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String clientEmail = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date clientBirthDate = sdf.parse(sc.next());
        Client client = new Client(clientName, clientEmail, clientBirthDate);
        System.out.println("Enter order data: ");
        Date dataHoraAtual = new Date();
        System.out.print("Status: ");
        String orderStatus = sc.next();
        Order order = new Order(dataHoraAtual, OrderStatus.valueOf(orderStatus), client);
        System.out.print("How many items to this order? ");
        int qtdItems = sc.nextInt();
        for (int i = 1; i<=qtdItems; i++){
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            String nameProduct = sc.next();
            System.out.print("Product price: ");
            double priceProduct = sc.nextDouble();
            System.out.print("Quantity: ");
            int qtdProduct = sc.nextInt();
            Product product = new Product(nameProduct, priceProduct);
            OrderItem orderItem = new OrderItem(qtdProduct, priceProduct, product);
            order.addItem(orderItem);
        }

        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.println(order);











        sc.close();
    }
}