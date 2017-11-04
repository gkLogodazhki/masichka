package com.websystique.springmvc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "place_types", schema = "masichka", catalog = "")
public class PlaceType implements Serializable {
    private Integer id;
    private String name;
    private List<PlacesHasOption> options;
    private List<Place> places;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaceType placeType = (PlaceType) o;

        if (id != placeType.id) return false;
        return name != null ? name.equals(placeType.name) : placeType.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "option")
    public List<PlacesHasOption> getOptions() {
        return options;
    }

    public void setOptions(List<PlacesHasOption> options) {
        this.options = options;
    }

    @OneToMany(mappedBy = "placeType")
    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "PlaceType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", options=" + options +
                ", places=" + places +
                '}';
    }
}
