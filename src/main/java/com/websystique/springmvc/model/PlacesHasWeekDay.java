package com.websystique.springmvc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;

@Entity
@Table(name = "places_has_week_days", schema = "masichka", catalog = "")
public class PlacesHasWeekDay implements Serializable {

    @Basic
    @Column(name = "morning", nullable = true, precision = 2)
    private BigDecimal morning;

    @Basic
    @Column(name = "afternoon", nullable = true, precision = 2)
    private BigDecimal afternoon;

    @Basic
    @Column(name = "evening", nullable = true, precision = 2)
    private BigDecimal evening;

    @Basic
    @Column(name = "open", nullable = false)
    private Time open;

    @Basic
    @Column(name = "close", nullable = false)
    private Time close;

    @Id
    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "id", nullable = false)
    private Place place;

    @Id
    @ManyToOne
    @JoinColumn(name = "week_day_id", referencedColumnName = "id", nullable = false)
    private WeekDay weekDay;


    public BigDecimal getMorning() {
        return morning;
    }

    public void setMorning(BigDecimal morning) {
        this.morning = morning;
    }

    public BigDecimal getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(BigDecimal afternoon) {
        this.afternoon = afternoon;
    }

    public BigDecimal getEvening() {
        return evening;
    }

    public void setEvening(BigDecimal evening) {
        this.evening = evening;
    }

    public Time getOpen() {
        return open;
    }

    public void setOpen(Time open) {
        this.open = open;
    }

    public Time getClose() {
        return close;
    }

    public void setClose(Time close) {
        this.close = close;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    @Override
    public String toString() {
        return "PlacesHasWeekDay{" +
                "morning=" + morning +
                ", afternoon=" + afternoon +
                ", evening=" + evening +
                ", open=" + open +
                ", close=" + close +
                ", place=" + place +
                ", weekDay=" + weekDay +
                '}';
    }
}
