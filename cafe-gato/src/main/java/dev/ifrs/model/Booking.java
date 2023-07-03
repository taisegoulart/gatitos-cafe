package dev.ifrs.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Represents a booking made by a user for a time frame.
 */
@Entity
public class Booking extends PanacheEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonManagedReference
    private User user; // Usuário que realiza o booking, a relação é ManyToOne pois um usuário pode
                       // realizar vários bookings

    @Column(nullable = false)
    private String startTime; // Início do booking

    @Column(nullable = false)
    private String endTime; // Fim do booking

    @Column(nullable = false)
    private boolean timeframeAvailable; // Indica se o timeframe está disponível

    // Constructors
    public Booking() {
    };

    public Booking(User user, String startTime, String endTime, boolean timeframeAvailable) {
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
        this.timeframeAvailable = timeframeAvailable;
    }

    public Booking(String startTime, String endTime, boolean timeframeAvailable) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.timeframeAvailable = timeframeAvailable;
    }

    // Getters & Setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public boolean isTimeframeAvailable() {
        return timeframeAvailable;
    }

    public void setTimeframeAvailable(boolean timeframeAvailable) {
        this.timeframeAvailable = timeframeAvailable;
    }

}
