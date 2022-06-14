package org.acme.model;

public class pickUpVan extends VendorType{

    private final static String capacityOfPickupVan = "medium";

    public pickUpVan(Long vendorTypeId, String vehicleNo) {
        super(vendorTypeId, vehicleNo, capacityOfPickupVan);
    }
}
