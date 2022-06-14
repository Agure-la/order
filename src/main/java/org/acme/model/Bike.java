package org.acme.model;

public class Bike extends VendorType{

    private final static String capacityOfBike = "small";

    public Bike(Long vendorTypeId, String vehicleNo) {
        super(vendorTypeId, vehicleNo, capacityOfBike);
    }

}
