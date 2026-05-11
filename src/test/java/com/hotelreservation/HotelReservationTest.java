package com.hotelreservation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HotelReservationTest {
    private HotelReservationService service;

    @BeforeEach
    public void setup() {
        service = new HotelReservationService();
        service.addHotel(new Hotel("Lakewood", 110));
        service.addHotel(new Hotel("Bridgewood", 150));
        service.addHotel(new Hotel("Ridgewood", 220));
    }

    @Test
    public void givenHotelDetails_WhenAdded_ShouldReturnSize() {
        assertEquals(3, service.getHotels().size());
    }

    @Test
    public void givenDateRange_ShouldReturnCheapestHotel() {
        String cheapestHotel = service.findCheapestHotel("10Sep2020", "11Sep2020");
        assertEquals("Lakewood, Total Rates: $220", cheapestHotel);
    }
}
