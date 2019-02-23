package com.ocr.thomas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RelayDeliveryTest {


    @Test
    public void Given_FreeRelay_WhenGettingDeliveryPrice_ThenGet0e(){
        Delivery delivery = new RelayDelivery(7);
        assertEquals(0.0, delivery.getPrice(), 0.01);
    }

    @Test
    public void Given_LowPriceRelay_WhenGettingDeliveryPrice_ThanGet2e99(){
        Delivery delivery = new RelayDelivery(32);
        assertEquals(2.99, delivery.getPrice(), 0.01);
    }

    @Test
    public void Given_HightPriceRelay_WhenGettingDeliveryPrice_ThenGet4e99(){
        Delivery delivery = new RelayDelivery(56);
        assertEquals(4.99, delivery.getPrice(), 0.01);
    }
}