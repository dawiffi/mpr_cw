
package org.example.service;

import org.example.Main;
import org.example.exception.PizzaNotFoundException;
import org.example.model.Order;
import org.example.model.Pizza;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.*;

public class PizzaService {
    private static final Logger logger = LogManager.getLogger(PizzaService.class);

    public List<Pizza> pizzaList;
    public List<Order> orderList = new ArrayList<>();

    public PizzaService(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    public Order makeOrder(List<Pizza> orderedPizzas) {
        //oczekujemy tu zwrocenia informacji o zamowieniu (nr zam.,pizza,cena)
        logger.info("Wywolano metode makeOrder.");
        if (getAvailablePizzas().containsAll(orderedPizzas)) {
            double sum = orderedPizzas.stream().map(Pizza::getPrice)
                    .reduce(0D, Double::sum);

            Order order = new Order(orderList.size(),
                    orderedPizzas,
                    sum
            );

            orderList.add(order);
            return order;
        } else {
            throw new PizzaNotFoundException("NIE ZNALEZIONO PIZZY");
        }

    }
    //przyjmujemy pizze
    //sprawdzamy czy jest ona dostepna
    //tworzymy zamowienie
    //nadajemy zamowieniu numer na podstawie istniejacej listy zamowien
    //dodajemy zamowienie do orderList
    //zwracamy zamowienie

    public List<Pizza> getAvailablePizzas() {
        logger.info("Wywolano metode getAvailablePizzas.");
        //oczekujemy listy dostepnych pizz oraz cen

        //zwrocenie listy pizz, ktore sa dostepne (filtrowanie po isAvailable)
        return pizzaList.stream().filter(Pizza::getAvailable).collect(Collectors.toList());
    }
}

