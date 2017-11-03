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
    private BigInteger spots;

    @Basic
    @Column(name = "discount", nullable = true, precision = 2)
    private BigDecimal discount;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "id", nullable = false)
    private Place place;


    public int getId() {
        return id;
    }

    public void setId(int id) {
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


    public BigInteger getSpots() {
        return spots;
    }

    public void setSpots(BigInteger spots) {
        this.spots = spots;
    }


    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (id != that.id) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (spots != null ? !spots.equals(that.spots) : that.spots != null) return false;
        return discount != null ? discount.equals(that.discount) : that.discount == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (spots != null ? spots.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        return result;
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