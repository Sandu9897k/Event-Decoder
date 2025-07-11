package com.altria.dialog.decoders.ericsson;

public class LocationPart {
    // Change to double if need more precision
    private Float degreesLatitude;
    private Float degreesLongitude;
    private int latitudeSign;

    public LocationPart() {

    }

    public LocationPart(long degreesLatitude, float degreesLongitude, int latitudeSign) {
        // This should be converted to degrees
        this.degreesLatitude = degreesLatitude / 8388608F * 90F;
        float lon = degreesLongitude / 16777216F * 360F;
        if (lon > 180) {
            this.degreesLongitude = lon - 180;
        } else {
            this.degreesLongitude = lon;
        }
    }

    public LocationPart(Float degreesLatitude, Float degreesLongitude, int latitudeSign) {
        this.degreesLatitude = degreesLatitude;
        this.degreesLongitude = degreesLongitude;
        this.latitudeSign = latitudeSign;
    }

    public Float getDegreesLatitude() {
        return degreesLatitude;
    }

    public void setDegreesLatitude(Float degreesLatitude) {
        this.degreesLatitude = degreesLatitude;
    }

    public Float getDegreesLongitude() {
        return degreesLongitude;
    }

    public void setDegreesLongitude(Float degreesLongitude) {
        this.degreesLongitude = degreesLongitude;
    }

    public int getLatitudeSign() {
        return latitudeSign;
    }

    public void setLatitudeSign(int latitudeSign) {
        this.latitudeSign = latitudeSign;
    }
}
