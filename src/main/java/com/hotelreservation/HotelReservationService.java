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

    public String findCheapestBestRatedHotel(String startDateStr, String endDateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMuuuu");
        LocalDate startDate = LocalDate.parse(startDateStr, formatter);
        LocalDate endDate = LocalDate.parse(endDateStr, formatter);

        long minTotalRate = Long.MAX_VALUE;
        List<Hotel> cheapestHotels = new ArrayList<>();

        for (Hotel hotel : hotels) {
            long totalRate = 0;
            LocalDate tempDate = startDate;
            while (!tempDate.isAfter(endDate)) {
                int dayOfWeek = tempDate.getDayOfWeek().getValue();
                if (dayOfWeek == 6 || dayOfWeek == 7) {
                    totalRate += hotel.getWeekendRate();
                } else {
                    totalRate += hotel.getWeekdayRate();
                }
                tempDate = tempDate.plusDays(1);
            }

            if (totalRate < minTotalRate) {
                minTotalRate = totalRate;
                cheapestHotels.clear();
                cheapestHotels.add(hotel);
            } else if (totalRate == minTotalRate) {
                cheapestHotels.add(hotel);
            }
        }

        if (!cheapestHotels.isEmpty()) {
            Hotel bestRatedCheapestHotel = cheapestHotels.stream()
                    .max(Comparator.comparingInt(Hotel::getRating))
                    .orElse(cheapestHotels.get(0));

            return bestRatedCheapestHotel.getName() + ", Rating: " + bestRatedCheapestHotel.getRating() + " and Total Rates: $" + minTotalRate;
        }
        return null;
    }

    public String findBestRatedHotel(String startDateStr, String endDateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMuuuu");
        LocalDate startDate = LocalDate.parse(startDateStr, formatter);
        LocalDate endDate = LocalDate.parse(endDateStr, formatter);

        Hotel bestRatedHotel = hotels.stream()
                .max(Comparator.comparingInt(Hotel::getRating))
                .orElse(null);

        if (bestRatedHotel != null) {
            long totalRate = 0;
            LocalDate tempDate = startDate;
            while (!tempDate.isAfter(endDate)) {
                int dayOfWeek = tempDate.getDayOfWeek().getValue();
                if (dayOfWeek == 6 || dayOfWeek == 7) {
                    totalRate += bestRatedHotel.getWeekendRate();
                } else {
                    totalRate += bestRatedHotel.getWeekdayRate();
                }
                tempDate = tempDate.plusDays(1);
            }
            return bestRatedHotel.getName() + " & Total Rates $" + totalRate;
        }
        return null;
    }
}
