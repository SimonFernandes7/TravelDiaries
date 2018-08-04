package com.traveldiaries.app;

public class Events {
    private String eventsName, Distance;

    public Events() {
    }

    public Events(String event, String distance) {
        this.eventsName = event;
        this.Distance = distance;
    }

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
