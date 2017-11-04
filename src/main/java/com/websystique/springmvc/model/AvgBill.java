package com.websystique.springmvc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "avg_bills", schema = "masichka", catalog = "")
public class AvgBill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "name", nullable = false, unique = true, length = 45)
    private String name;

    @OneToMany(mappedBy = "avgBill")
    private List<Place> places;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AvgBill avgBill = (AvgBill) o;

        if (id != avgBill.id) return false;
        return name != null ? name.equals(avgBill.name) : avgBill.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AvgBill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", places=" + places +
                '}';
    }
}
