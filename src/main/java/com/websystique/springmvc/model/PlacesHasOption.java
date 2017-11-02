package com.websystique.springmvc.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "places_has_options", schema = "masichka", catalog = "")
public class PlacesHasOption implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "id", nullable = false)
    private Place place;

    @Id
    @ManyToOne
    @JoinColumn(name = "option_id", referencedColumnName = "id", nullable = false)
    private Option option;

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "PlacesHasOption{" +
                "place=" + place +
                ", option=" + option +
                '}';
    }
}
