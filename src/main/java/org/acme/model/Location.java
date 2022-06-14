package org.acme.model;

import javax.persistence.*;

@Entity
@Table(name = "Location")
public class Location {

    @Id
    @Column(name = "locationId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "latitude")
    private Double latitude;

    public Location() {
    }

    public Location(Long locationId, Double longitude, Double latitude) {
        this.locationId = locationId;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Long getLocationId() {
        return locationId;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
