package com.websystique.springmvc.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "favourite_places", schema = "masichka", catalog = "")
public class FavouritePlace implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "id", nullable = false)
    private Place place;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FavouritePlace that = (FavouritePlace) o;

        if (!getUser().equals(that.getUser())) return false;
        return getPlace().equals(that.getPlace());
    }

    @Override
    public int hashCode() {
        int result = getUser().hashCode();
        result = 31 * result + getPlace().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "FavouritePlace{" +
                "user=" + user +
                ", place=" + place +
                '}';
    }
}
