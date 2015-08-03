package com.forged.openvoting.voting_system.data;

import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

/**
 * Created by visitor15 on 8/2/15.
 */
public class Location {

    private String id;
    private String name;

    @GeoSpatialIndexed
    private double[] coordinates;

    public Location() {
        this.id = "";
        this.name = "";
        initLocationList(0.0, 0.0);
    }

    public Location(final String name, final double lat, final double lon) {
        this.id = "";
        this.name = name;
        initLocationList(lat, lon);
    }

    public double[] getCoordinates() {
        return this.coordinates;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setLatitude(final double latitude) {
        this.coordinates[0] = latitude;
    }

    public void setLongitude(final double longitude) {
        this.coordinates[1] = longitude;
    }

    private void initLocationList(final double lat, final double lon) {
        this.coordinates = new double[2];
        this.coordinates[0] = lat;
        this.coordinates[1] = lon;
    }
}
