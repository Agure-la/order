package org.acme.model;

import javax.persistence.*;

@Entity
@Table(name = "VendorType")
public class VendorType {

    @Id
    @Column(name = "VendorTypeId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long vendorTypeId;

    @Column(name = "vehicleNo")
    private String vehicleNo;

    @Column(name = "capacity")
    private String capacity;

    //private Location currentPosition;

    private VehicleStatus currentStatus;

    public VendorType() {
    }

    public VendorType(Long vendorTypeId, String vehicleNo, String capacity) {
        this.vendorTypeId = vendorTypeId;
        this.vehicleNo = vehicleNo;
        this.capacity = capacity;
//        this.currentPosition = currentPosition;
//        this.currentStatus = currentStatus;
    }

    public Long getVendorTypeId() {
        return vendorTypeId;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

//    public Location getCurrentPosition() {
//        return currentPosition;
//    }
//
//   public void setCurrentPosition(Location currentPosition) {
//        this.currentPosition = currentPosition;
//    }

    public VehicleStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(VehicleStatus currentStatus) {
        this.currentStatus = currentStatus;
    }
}
