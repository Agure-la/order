package org.acme.model;

public class Truck extends VendorType{

    private final static String capacityOfTruck = "large";

    public Truck(Long vendorTypeId, String vehicleNo) {
        super(vendorTypeId, vehicleNo, capacityOfTruck);
    }

}
