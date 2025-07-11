package com.altria.dialog.decoders.huawei;

public class UserLocation {
    private long degreesLatitude;
    private long degreesLongitude;
    private int latitudeSign;
    private int altitude;
    private int altitudeDirection;
    private boolean isEmpty = true;

    public UserLocation() {

    }

    public UserLocation(long degreesLatitude, long degreesLongitude, int latitudeSign, int altitude, int altitudeDirection) {
        this.degreesLatitude = degreesLatitude;
        this.degreesLongitude = degreesLongitude;
        this.latitudeSign = latitudeSign;
        this.altitude = altitude;
        this.altitudeDirection = altitudeDirection;
        this.isEmpty = false;
    }

    public UserLocation(long degreesLatitude, long degreesLongitude, int latitudeSign) {
        this.degreesLatitude = degreesLatitude;
        this.degreesLongitude = degreesLongitude;
        this.latitudeSign = latitudeSign;
    }

    public long getDegreesLatitude() {
        return degreesLatitude;
    }

    public long getDegreesLongitude() {
        return degreesLongitude;
    }

    public int getLatitudeSign() {
        return latitudeSign;
    }

    public int getAltitude() {
        return altitude;
    }

    public int getAltitudeDirection() {
        return altitudeDirection;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}
