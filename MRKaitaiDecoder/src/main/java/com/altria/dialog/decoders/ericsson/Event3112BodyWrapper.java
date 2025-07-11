package com.altria.dialog.decoders.ericsson;

import com.altria.dialog.parsers.kaitai.ericsson.EricssonEventFile;

public class Event3112BodyWrapper {
    private EricssonEventFile.TEvent3112Body record;
    private Integer ta = null;
    private LocationPart locationPart;

    public EricssonEventFile.TEvent3112Body getRecord() {
        return record;
    }

    public Integer getTa() {
        return ta;
    }

    public void setTa(Integer ta) {
        this.ta = ta;
    }

    public Event3112BodyWrapper(EricssonEventFile.TEvent3112Body record) {
        this.record = record;
    }

    public void setLocation(LocationPart locationPart) {
        this.locationPart = locationPart;
    }

    public LocationPart getLocationPart() {
        return locationPart;
    }
}
