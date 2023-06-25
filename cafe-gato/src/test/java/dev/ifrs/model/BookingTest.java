package dev.ifrs.model;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookingTest {
    @Test
    public void testCreateBooking() {
        // Create a new Booking instance
        LocalDateTime startTime = LocalDateTime.parse("2023-06-30T13:00:00");
        LocalDateTime endTime = LocalDateTime.parse("2023-06-30T13:30:00");
        Booking booking = new Booking(startTime, endTime, true);

        // Verify the attributes
        Assertions.assertEquals(startTime, booking.getStartTime());
        Assertions.assertEquals(endTime, booking.getEndTime());
        Assertions.assertTrue(booking.isTimeframeAvailable());
    }

    @Test
    public void testSettersAndGetters() {
        // Create a new Booking instance
        Booking booking = new Booking();

        // Set the attributes
        LocalDateTime startTime = LocalDateTime.parse("2023-07-01T15:00:00");
        LocalDateTime endTime = LocalDateTime.parse("2023-07-01T16:00:00");
        booking.setStartTime(startTime);
        booking.setEndTime(endTime);
        booking.setTimeframeAvailable(false);

        // Verify the attributes using getters
        Assertions.assertEquals(startTime, booking.getStartTime());
        Assertions.assertEquals(endTime, booking.getEndTime());
        Assertions.assertFalse(booking.isTimeframeAvailable());
    }

    @Test
    public void testEqualsAndHashCode() {
        // Create two identical Booking instances
        LocalDateTime startTime = LocalDateTime.parse("2023-06-30T13:00:00");
        LocalDateTime endTime = LocalDateTime.parse("2023-06-30T13:30:00");
        Booking booking1 = new Booking(startTime, endTime, true);
        Booking booking2 = new Booking(startTime, endTime, true);

        // Verify the equality using equals method
        Assertions.assertEquals(booking1, booking2);

        // Verify the equality using hashCode method
        Assertions.assertEquals(booking1.hashCode(), booking2.hashCode());
    }
    
}
