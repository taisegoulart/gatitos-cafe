package dev.ifrs.model;

import java.time.LocalDateTime;



public class Booking  {
//TODO: booking pode estar ou não ligado ao usuário, se não estiver ligado ao usuário, o usuário é null
    private User user;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean timeframeAvailable;

   // Constructors, getters, and setters

   public Booking (){};

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

    public Booking(LocalDateTime startTime, LocalDateTime endTime, boolean timeframeAvailable) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.timeframeAvailable = timeframeAvailable;
    }
    
    
    
}
