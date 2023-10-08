package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.exception.PizzaNotFoundException;
import org.example.model.*;
import org.example.service.*;

import java.util.List;
import java.util.logging.Level;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Pizza pizza1 = new Pizza("Capriciosa", true, 20);
        Pizza pizza2 = new Pizza("Hawajska", true, 35);
        Pizza pizza3 = new Pizza("Margharita", false, 25);
        Pizza pizza4 = new Pizza("Salami", false, 15);


        PizzaService pizzaService = new PizzaService(List.of(pizza1, pizza2, pizza3, pizza4));

        System.out.println(pizzaService.getAvailablePizzas());

        try {
            Order order1 = pizzaService.makeOrder(List.of(pizza1, pizza2));
            Order order2 = pizzaService.makeOrder(List.of(pizza1));

            System.out.println(order1);
            System.out.println();
            System.out.println(order2);

            Order order3 = pizzaService.makeOrder(List.of(pizza4));

            Order order4 = pizzaService.makeOrder(List.of(new Pizza("NieIstniejacaPizza", false, 0)));
        } catch (PizzaNotFoundException e) {
            logger.error("BLAD ZAMOWIENIA - zamowiono nieistniejaca pizze", e);
        }
    }
}