package com.hotelreservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HotelReservationService {
    private List<Hotel> hotels;

    public HotelReservationService() {
        this.hotels = new ArrayList<>();
    }

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public String findCheapestHotel(String startDateStr, String endDateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMuuuu");
        LocalDate startDate = LocalDate.parse(startDateStr, formatter);
        LocalDate endDate = LocalDate.parse(endDateStr, formatter);

        long numberOfDays = ChronoUnit.DAYS.between(startDate, endDate) + 1;

        Hotel cheapestHotel = hotels.stream()
                .min(Comparator.comparingInt(h -> h.getRegularRate()))
                .orElse(null);

        if (cheapestHotel != null) {
            long totalRate = cheapestHotel.getRegularRate() * numberOfDays;
            return cheapestHotel.getName() + ", Total Rates: $" + totalRate;
        }
        return null;
    }
}
