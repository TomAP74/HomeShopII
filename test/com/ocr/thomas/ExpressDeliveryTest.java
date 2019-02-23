package com.ocr.thomas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressDeliveryTest {

    @Test
    public void Given_RegionCityAsLocation_When_GettingDeliveryPrice_Then_Get9e99(){
        Delivery delivery = new ExpressDelivery("Lyon");
        assertEquals(9.99, delivery.getPrice(), 0.01);
    }

    @Test
    public void Given_ParisAsLocation_When_GettingDeliveryPrice_Then_Get6e99(){
        Delivery delivery = new ExpressDelivery("Paris");
        assertEquals(6.99, delivery.getPrice(), 0.01);
    }
}