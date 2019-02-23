package com.ocr.thomas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RelayDeliveryTest {


    @Test
    public void Given_FreeRelay_When_GettingDeliveryPrice_Then_Get0e(){
        Delivery delivery = new RelayDelivery(7);
        assertEquals(0.0, delivery.getPrice(), 0.01);
    }

    @Test
    public void Given_LowPriceRelay_When_GettingDeliveryPrice_Than_Get2e99(){
        Delivery delivery = new RelayDelivery(32);
        assertEquals(2.99, delivery.getPrice(), 0.01);
    }

    @Test
    public void Given_HightPriceRelay_When_GettingDeliveryPrice_Then_Get4e99(){
        Delivery delivery = new RelayDelivery(56);
        assertEquals(4.99, delivery.getPrice(), 0.01);
    }
}