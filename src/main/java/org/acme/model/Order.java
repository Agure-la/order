package org.acme.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @Column(name = "orderId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "orderNumber")
    private String orderNo;


//    private Location pickUpLocation;
//
//
//    private Location destination;

    @Column(name = "timeRaised")
    private Date timePlaced;

    @Column(name = "timeDelivered")
    private Date timeDelivered;


//    private VendorType vehicleOfThisOrder;
//
//
//    private User customer;

    private OrderStatus orderStatus;

    public Long getOrderId() {
        return orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

//    public Location getPickUpLocation() {
//        return pickUpLocation;
//    }
//
//    public void setPickUpLocation(Location pickUpLocation) {
//        this.pickUpLocation = pickUpLocation;
//    }
//
//    public Location getDestination() {
//        return destination;
//    }
//
//    public void setDestination(Location destination) {
//        this.destination = destination;
//    }

    public Date getTimePlaced() {
        return timePlaced;
    }

    public void setTimePlaced(Date timePlaced) {
        this.timePlaced = timePlaced;
    }

    public Date getTimeDelivered() {
        return timeDelivered;
    }

    public void setTimeDelivered(Date timeDelivered) {
        this.timeDelivered = timeDelivered;
    }

//    public VendorType getVehicleOfThisOrder() {
//        return vehicleOfThisOrder;
//    }
//
//    public void setVehicleOfThisOrder(VendorType vehicleOfThisOrder) {
//        this.vehicleOfThisOrder = vehicleOfThisOrder;
//    }
//
//    public User getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(User customer) {
//        this.customer = customer;
//    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
