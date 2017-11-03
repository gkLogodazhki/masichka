package com.websystique.springmvc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "reservations", schema = "masichka", catalog = "")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "date", nullable = false)
    private Timestamp date;

    @Basic
    @Column(name = "reservation_status", nullable = false)
    private boolean reservationStatus;

    @Basic
    @Column(name = "spots", nullable = false, precision = 0)
    private Byte spots;

    @Basic
    @Column(name = "discount", nullable = true, precision = 2)
    private Byte discount;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "id", nullable = false)
    private Place place;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }


    public boolean getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(boolean reservationStatus) {
        this.reservationStatus = reservationStatus;
    }


    public Byte getSpots() {
        return spots;
    }

    public void setSpots(Byte spots) {
        this.spots = spots;
    }


    public Byte getDiscount() {
        return discount;
    }

    public void setDiscount(Byte discount) {
        this.discount = discount;
    }

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

        Reservation that = (Reservation) o;

        if (!getId().equals(that.getId())) return false;
        if (!getUser().equals(that.getUser())) return false;
        return getPlace().equals(that.getPlace());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getUser().hashCode();
        result = 31 * result + getPlace().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", date=" + date +
                ", reservationStatus=" + reservationStatus +
                ", spots=" + spots +
                ", discount=" + discount +
                ", user=" + user +
                ", place=" + place +
                '}';
    }
}
