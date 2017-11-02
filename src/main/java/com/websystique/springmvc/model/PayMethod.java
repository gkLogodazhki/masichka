package com.websystique.springmvc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "pay_methods", schema = "masichka", catalog = "")
public class PayMethod implements Serializable {
    private Integer id;
    private String name;
    private List<PlacesHasPayMethod> payMethods;

    @Id
    @Column(name = "id", nullable = false, unique = true)
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

        PayMethod payMethod = (PayMethod) o;

        if (id != payMethod.id) return false;
        return name != null ? name.equals(payMethod.name) : payMethod.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "payMethod")
    public List<PlacesHasPayMethod> getPayMethods() {
        return payMethods;
    }

    public void setPayMethods(List<PlacesHasPayMethod> payMethods) {
        this.payMethods = payMethods;
    }

    @Override
    public String toString() {
        return "PayMethod{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", payMethods=" + payMethods +
                '}';
    }
}
