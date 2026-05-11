package com.hotelreservation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HotelReservationTest {
    private HotelReservationService service;

    @BeforeEach
    public void setup() {
        service = new HotelReservationService();
        service.addHotel(new Hotel("Lakewood", 110, 90, 3, 80, 80));
        service.addHotel(new Hotel("Bridgewood", 150, 50, 4, 110, 50));
        service.addHotel(new Hotel("Ridgewood", 220, 150, 5, 100, 40));
    }

    @Test
    public void givenHotelDetails_WhenAdded_ShouldReturnSize() {
        assertEquals(3, service.getHotels().size());
    }

    @Test
    public void givenDateRange_WhenWeekday_ShouldReturnCheapestBestRatedHotel() {
        String hotel = service.findCheapestBestRatedHotel("10Sep2020", "11Sep2020");
        assertEquals("Lakewood, Rating: 3 and Total Rates: $220", hotel);
    }

    @Test
    public void givenDateRange_WhenWeekdayAndWeekend_ShouldReturnCheapestBestRatedHotel() {
        String hotel = service.findCheapestBestRatedHotel("11Sep2020", "12Sep2020");
        assertEquals("Bridgewood, Rating: 4 and Total Rates: $200", hotel);
    }

    @Test
    public void givenDateRange_ShouldReturnBestRatedHotel() {
        String hotel = service.findBestRatedHotel("11Sep2020", "12Sep2020");
        assertEquals("Ridgewood & Total Rates $370", hotel);
    }

    @Test
    public void givenDateRangeAndRewardsCustomer_ShouldReturnCheapestBestRatedHotel() throws Exception {
        String hotel = service.findCheapestBestRatedHotel("Rewards", "11Sep2020", "12Sep2020");
        assertEquals("Ridgewood, Rating: 5 and Total Rates: $140", hotel);
    }

    @Test
    public void givenInvalidCustomerType_ShouldThrowException() {
        try {
            service.findCheapestBestRatedHotel("Invalid", "11Sep2020", "12Sep2020");
        } catch (Exception e) {
            assertEquals("Invalid Customer Type", e.getMessage());
        }
    }

    @Test
    public void givenInvalidDate_ShouldThrowException() {
        try {
            service.findCheapestBestRatedHotel("Rewards", "11/09/2020", "12Sep2020");
        } catch (Exception e) {
            assertEquals("Invalid Date Format", e.getMessage());
        }
    }
}
