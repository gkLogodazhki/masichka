package com.websystique.springmvc.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "places_has_pay_methods", schema = "masichka", catalog = "")
public class PlacesHasPayMethod implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "id", nullable = false)
    private Place place;

    @Id
    @ManyToOne
    @JoinColumn(name = "pay_method_id", referencedColumnName = "id", nullable = false)
    private PayMethod payMethod;

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }


    public PayMethod getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(PayMethod payMethod) {
        this.payMethod = payMethod;
    }

    @Override
    public String toString() {
        return "PlacesHasPayMethod{" +
                "place=" + place +
                ", payMethod=" + payMethod +
                '}';
    }
}
