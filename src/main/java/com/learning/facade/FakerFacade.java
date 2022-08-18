package com.learning.facade;

import com.github.javafaker.Faker;

/**
 * @author Sreej
 */
public class FakerFacade {

    public static void getBuildingNumber() {
        new Faker().address().buildingNumber();
    }


}
