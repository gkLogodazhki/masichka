package com.websystique.springmvc.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "places_has_setups", schema = "masichka", catalog = "")
public class PlacesHasSetup implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "id", nullable = false)
    private Place place;

    @Id
    @ManyToOne
    @JoinColumn(name = "setup_id", referencedColumnName = "id", nullable = false)
    private Setup setup;


    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Setup getSetup() {
        return setup;
    }

    public void setSetup(Setup setup) {
        this.setup = setup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlacesHasSetup that = (PlacesHasSetup) o;

        if (!getPlace().equals(that.getPlace())) return false;
        return getSetup().equals(that.getSetup());
    }

    @Override
    public int hashCode() {
        int result = getPlace().hashCode();
        result = 31 * result + getSetup().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PlacesHasSetup{" +
                "place=" + place +
                ", setup=" + setup +
                '}';
    }
}
