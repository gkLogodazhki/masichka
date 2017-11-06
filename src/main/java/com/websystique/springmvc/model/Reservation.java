package com.websystique.springmvc.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "reservations", schema = "masichka", catalog = "")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

<<<<<<< HEAD
=======
    @NotEmpty
    @Column(name = "date", nullable = false)
    private Timestamp date;

    @NotEmpty
    @Column(name = "spots", nullable = false)
    private Integer spots;

    @NotEmpty
    @Column(name = "discount", nullable = false)
    private Integer discount;

>>>>>>> 79b18c2912e035a9233fdf0d6ca6e52b3d836e3b
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "id", nullable = false)
    private Place place;

    @ManyToOne
    @JoinColumn(name = "hours_id", nullable = false)
    private Hour hour;

    @NotNull
    @Column(name = "discount", nullable = true)
    private Integer discount;

    @NotNull
    @Column(name = "date", nullable = true)
    private String date;

    @NotNull
    @Column(name = "spots", nullable = true)
    private Integer spots;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

<<<<<<< HEAD
=======
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Integer getSpots() {
        return spots;
    }

    public void setSpots(Integer spots) {
        this.spots = spots;
    }


    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
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

>>>>>>> 79b18c2912e035a9233fdf0d6ca6e52b3d836e3b
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

<<<<<<< HEAD
	

	public Integer getSpots() {
		return spots;
	}

	public void setSpots(Integer spots) {
		this.spots = spots;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
		result = prime * result + ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + ((getHour() == null) ? 0 : getHour().hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((spots == null) ? 0 : spots.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		if (getDate() == null) {
			if (other.getDate() != null)
				return false;
		} else if (!getDate().equals(other.getDate()))
			return false;
		if (discount == null) {
			if (other.discount != null)
				return false;
		} else if (!discount.equals(other.discount))
			return false;
		if (getHour() == null) {
			if (other.getHour() != null)
				return false;
		} else if (!getHour().equals(other.getHour()))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (spots == null) {
			if (other.spots != null)
				return false;
		} else if (!spots.equals(other.spots))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", user=" + user + ", place=" + place + ", hour=" + getHour() + ", discount="
				+ discount + ", date=" + getDate() + ", spots=" + spots + "]";
	}

	public Hour getHour() {
		return hour;
	}

	public void setHour(Hour hour) {
		this.hour = hour;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		date = date.replaceAll("/", ".");
		System.out.println(date);
		this.date = date;
	}
	
=======
    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", date=" + date +
                ", spots=" + spots +
                ", discount=" + discount +
                ", user=" + user +
                ", place=" + place +
                '}';
    }
>>>>>>> 79b18c2912e035a9233fdf0d6ca6e52b3d836e3b
}
