package com.websystique.springmvc.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "places", schema = "masichka", catalog = "")
public class Place implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotEmpty
    @Pattern(regexp = "[A-Za-z0-9]+")
    @Column(name = "logo", nullable = false, length = 45)
    private String logo;

    @NotEmpty
    @Pattern(regexp = "[A-Za-z0-9_\\s]+")
    @Column(name = "name", nullable = false, length = 99, unique = true)
    private String name;

    @NotEmpty
    @Pattern(regexp = "[A-Za-z0-9_\\s]+")
    @Column(name = "address", nullable = false, length = 45)
    private String address;

    @NotEmpty
    @Pattern(regexp = "[A-Za-z0-9]+")
    @Column(name = "path_to_gallery", nullable = false, length = 45)
    private String pathToGallery;

    @NotNull
    @Min(-90) @Max(90)
    @Column(name = "map_lat", nullable = false)
    private Integer mapLat;

    @NotNull
    @Min(-180) @Max(180)
    @Column(name = "map_lng", nullable = false)
    private Integer mapLng;

    @NotEmpty
    @Pattern(regexp = "[A-Za-z0-9/]+")
    @Column(name = "info_place", nullable = false, length = 300)
    private String infoPlace;

    @NotNull
    @Min(1) @Max(100)
    @Column(name = "spots", nullable = false)
    private Integer spots;

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


    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "places_has_options",
            joinColumns = {@JoinColumn(name = "place_id")},
            inverseJoinColumns = {@JoinColumn(name = "option_id")})
    private Set<Option> options = new HashSet<Option>();

    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "places_has_pay_methods",
            joinColumns = {@JoinColumn(name = "place_id")},
            inverseJoinColumns = {@JoinColumn(name = "pay_method_id")})
    private Set<PayMethod> payMethods = new HashSet<PayMethod>();

    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "places_has_setups",
            joinColumns = {@JoinColumn(name = "place_id")},
            inverseJoinColumns = {@JoinColumn(name = "setup_id")})
    private Set<Setup> setups = new HashSet<Setup>();

    //    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "places_has_week_days",
            joinColumns = {@JoinColumn(name = "place_id")},
            inverseJoinColumns = {@JoinColumn(name = "week_day_id")})
    private Set<WeekDay> weekDays = new HashSet<WeekDay>();

//    @NotEmpty
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "comments",
//            joinColumns = { @JoinColumn(name = "place_id") },
//            inverseJoinColumns = { @JoinColumn(name = "user_id") })
//    private Set<Comment> comments = new HashSet<Comment>();

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
//
//    public Set<Comment> getComments() {
//        return comments;
//    }
//
//    public void setComments(Set<Comment> comments) {
//        this.comments = comments;
//    }

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

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }

    public Set<PayMethod> getPayMethods() {
        return payMethods;
    }

    public void setPayMethods(Set<PayMethod> payMethods) {
        this.payMethods = payMethods;
    }

    public Set<Setup> getSetups() {
        return setups;
    }

    public void setSetups(Set<Setup> setups) {
        this.setups = setups;
    }

    public Set<WeekDay> getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(Set<WeekDay> weekDays) {
        this.weekDays = weekDays;
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
//                ", comments=" + comments +
                ", placeType=" + placeType +
                ", region=" + region +
                ", avgBill=" + avgBill +
                ", options=" + options +
                ", payMethods=" + payMethods +
                ", setups=" + setups +
                ", weekDays=" + weekDays +
                '}';
    }
}
