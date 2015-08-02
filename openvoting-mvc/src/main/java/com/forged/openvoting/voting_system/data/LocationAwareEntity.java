package com.forged.openvoting.voting_system.data;

import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

/**
 * Created by visitor15 on 8/2/15.
 */
public class LocationAwareEntity extends ErrorProneEntity {

    private String id;
    private String name;

    private Location location;

    public LocationAwareEntity() {
        this.name = "";
        this.location = new Location();
    }

    public LocationAwareEntity(final Location location) {
        this.name = "";
        this.location = location;
    }

    public LocationAwareEntity(final String name, final double latitude, final double longitude) {
        this.name = name;
        this.location = new Location("", latitude, longitude);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(double[] location) {
        this.location = new Location("", location[0], location[1]);
    }
}
