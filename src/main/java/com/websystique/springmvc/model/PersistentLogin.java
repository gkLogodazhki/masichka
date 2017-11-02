package com.websystique.springmvc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "persistent_logins", schema = "masichka", catalog = "")
public class PersistentLogin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "series", nullable = false, length = 64)
    private String series;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "token", unique = true, nullable = false)
    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_used", nullable = false)
    private Date lastUsed;

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(Date lastUsed) {
        this.lastUsed = lastUsed;
    }

    @Override
    public String toString() {
        return "PersistentLogin{" +
                "series='" + series + '\'' +
                ", username='" + username + '\'' +
                ", token='" + token + '\'' +
                ", lastUsed=" + lastUsed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersistentLogin that = (PersistentLogin) o;

        if (series != null ? !series.equals(that.series) : that.series != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;
        return lastUsed != null ? lastUsed.equals(that.lastUsed) : that.lastUsed == null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (series != null ? series.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (lastUsed != null ? lastUsed.hashCode() : 0);
        return result;
    }
}
