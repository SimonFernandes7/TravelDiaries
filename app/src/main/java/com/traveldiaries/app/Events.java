package com.traveldiaries.app;

public class Events {
    private String eventsName, Distance;
    private Boolean organised;

    public Events() {
    }

    public Events(String event, String distance) {
        this.eventsName = event;
        this.Distance = distance;
        this.organised = false;
    }

    public  Events(String event, String distance, Boolean organised) {
        this.eventsName = event;
        this.Distance = distance;
        this.organised = organised;
    }

    public Boolean getOrganised() { return organised; }

    public void setOrganised(Boolean organised) { this.organised = organised; }

    public String getEventsName() {
        return eventsName;
    }

    public void setEventsName(String name) {
        this.eventsName = name;
    }

    public String getDistance() {
        return Distance;
    }

    public void setDistance(String distance) {
        this.Distance = distance;
    }
}
