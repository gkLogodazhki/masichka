package com.websystique.springmvc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "comments", schema = "masichka", catalog = "")
public class Comment implements Serializable {

    @Basic
    @Column(name = "rating", nullable = true)
    private Integer rating;

    @Basic
    @Column(name = "comment", nullable = true, length = 300)
    private String comment;

    @Basic
    @Column(name = "date", nullable = false)
    private Timestamp date;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "id", nullable = false)
    private Place place;

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
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

        Comment comment1 = (Comment) o;

        if (rating != null ? !rating.equals(comment1.rating) : comment1.rating != null) return false;
        if (comment != null ? !comment.equals(comment1.comment) : comment1.comment != null) return false;
        return date != null ? date.equals(comment1.date) : comment1.date == null;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "rating=" + rating +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                ", user=" + user +
                ", place=" + place +
                '}';
    }
}
