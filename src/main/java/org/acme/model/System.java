package org.acme.model;

import java.util.ArrayList;
import java.util.List;

public class System {

    private  List<Order> orders;
    private  List<VendorType> vendorTypes;
    private List<User> users;

    public System() {
        this.orders = new ArrayList<Order>();
        this.vendorTypes = new ArrayList<VendorType>();
        this.users = new ArrayList<User>();
    }
}
