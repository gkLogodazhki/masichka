package com.websystique.springmvc.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "places", schema = "masichka", catalog = "")
public class Place implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "logo", nullable = false, length = 45)
    private String logo;

    @NotNull
    @Column(name = "name", nullable = false, length = 99, unique = true)
    private String name;

    @NotNull
    @Column(name = "address", nullable = false, length = 45)
    private String address;

    @NotNull
    @Column(name = "path_to_gallery", nullable = false, length = 45)
    private String pathToGallery;

    @NotNull
    @Column(name = "map_lat", nullable = false)
    private Integer mapLat;

    @NotNull
    @Column(name = "map_lng", nullable = false)
    private Integer mapLng;

    @Basic
    @NotNull
    @Column(name = "info_place", nullable = false, length = 300)
    private String infoPlace;

    @NotNull
    @Column(name = "spots", nullable = false)
    private Integer spots;

    @OneToMany(mappedBy = "place")
    private Collection<Comment> comments;

    @OneToMany(mappedBy = "place")
    private Collection<FavouritePlace> favouritePlaces;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "place_type_id", referencedColumnName = "id", nullable = false)
    private PlaceType placeType;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "region_id", referencedColumnName = "id", nullable = false)
    private Region region;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "avg_bill_id", referencedColumnName = "id", nullable = false)
    private AvgBill avgBill;

    @NotNull
    @OneToMany(mappedBy = "place")
    private List<PlacesHasOption> options;

    @NotNull
    @OneToMany(mappedBy = "place")
    private List<PlacesHasPayMethod> payMethods;

    @NotNull
    @OneToMany(mappedBy = "place")
    private List<PlacesHasSetup> setups;

    @NotNull
    @OneToMany(mappedBy = "place")
    private List<PlacesHasWeekDay> weekDays;

    @NotNull
    @OneToMany(mappedBy = "place")
    private List<Reservation> reservations;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getPathToGallery() {
        return pathToGallery;
    }

    public void setPathToGallery(String pathToGallery) {
        this.pathToGallery = pathToGallery;
    }


    public Integer getMapLat() {
        return mapLat;
    }

    public void setMapLat(Integer mapLat) {
        this.mapLat = mapLat;
    }


    public Integer getMapLng() {
        return mapLng;
    }

    public void setMapLng(Integer mapLng) {
        this.mapLng = mapLng;
    }


    public String getInfoPlace() {
        return infoPlace;
    }

    public void setInfoPlace(String infoPlace) {
        this.infoPlace = infoPlace;
    }


    public Integer getSpots() {
        return spots;
    }

    public void setSpots(Integer spots) {
        this.spots = spots;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    public Collection<FavouritePlace> getFavouritePlaces() {
        return favouritePlaces;
    }

    public void setFavouritePlaces(Collection<FavouritePlace> favouritePlaces) {
        this.favouritePlaces = favouritePlaces;
    }

    public PlaceType getPlaceType() {
        return placeType;
    }

    public void setPlaceType(PlaceType placeType) {
        this.placeType = placeType;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public AvgBill getAvgBill() {
        return avgBill;
    }

    public void setAvgBill(AvgBill avgBill) {
        this.avgBill = avgBill;
    }


    public List<PlacesHasOption> getOptions() {
        return options;
    }

    public void setOptions(List<PlacesHasOption> options) {
        this.options = options;
    }

    public List<PlacesHasPayMethod> getPayMethods() {
        return payMethods;
    }

    public void setPayMethods(List<PlacesHasPayMethod> payMethods) {
        this.payMethods = payMethods;
    }

    public List<PlacesHasSetup> getSetups() {
        return setups;
    }

    public void setSetups(List<PlacesHasSetup> setups) {
        this.setups = setups;
    }

    public List<PlacesHasWeekDay> getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(List<PlacesHasWeekDay> weekDays) {
        this.weekDays = weekDays;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Place place = (Place) o;

        return getName().equals(place.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", logo='" + logo + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", pathToGallery='" + pathToGallery + '\'' +
                ", mapLat=" + mapLat +
                ", mapLng=" + mapLng +
                ", infoPlace='" + infoPlace + '\'' +
                ", spots=" + spots +
                ", comments=" + comments +
                ", favouritePlaces=" + favouritePlaces +
                ", placeType=" + placeType +
                ", region=" + region +
                ", avgBill=" + avgBill +
                ", options=" + options +
                ", payMethods=" + payMethods +
                ", setups=" + setups +
                ", weekDays=" + weekDays +
                ", reservations=" + reservations +
                '}';
    }
}
