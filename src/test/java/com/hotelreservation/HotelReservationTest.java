package com.hotelreservation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HotelReservationTest {
    private HotelReservationService service;

    @BeforeEach
    public void setup() {
        service = new HotelReservationService();
        service.addHotel(new Hotel("Lakewood", 110, 90, 3));
        service.addHotel(new Hotel("Bridgewood", 150, 50, 4));
        service.addHotel(new Hotel("Ridgewood", 220, 150, 5));
    }

    @Test
    public void givenHotelDetails_WhenAdded_ShouldReturnSize() {
        assertEquals(3, service.getHotels().size());
    }

    @Test
    public void givenDateRange_WhenWeekday_ShouldReturnCheapestHotel() {
        String cheapestHotel = service.findCheapestHotel("10Sep2020", "11Sep2020");
        assertEquals("Lakewood, Total Rates: $220", cheapestHotel);
    }

    @Test
    public void givenDateRange_WhenWeekdayAndWeekend_ShouldReturnCheapestHotels() {
        String cheapestHotel = service.findCheapestHotel("11Sep2020", "12Sep2020");
        assertEquals("Lakewood and Bridgewood, Total Rates: $200", cheapestHotel);
    }
}
