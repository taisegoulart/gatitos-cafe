package dev.ifrs.model;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;

import javax.persistence.*;
import java.time.LocalDateTime;

//TODO: COLOCAR EM PASTAS DIFERENTES PARA SEREM SERVIÇOS DIFERENTWS, CUIDAR A COMUNICAÇÃO COM O PORPERTIES

@Entity
public class Booking extends PanacheEntityBase {

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(nullable =false)
    private boolean timeframeAvailable;

   // Constructors, getters, and setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public boolean isTimeframeAvailable() {
        return timeframeAvailable;
    }

    public void setTimeframeAvailable(boolean timeframeAvailable) {
        this.timeframeAvailable = timeframeAvailable;
    }

    public Booking(User user, LocalDateTime startTime, LocalDateTime endTime, boolean timeframeAvailable) {
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
        this.timeframeAvailable = timeframeAvailable;
    }
    

    

 
    
    
}
