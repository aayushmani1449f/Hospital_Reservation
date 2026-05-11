package com.hotelreservation;

public class Hotel {
    private String name;
    private int weekdayRate;
    private int weekendRate;
    private int rating;
    private int rewardsWeekdayRate;
    private int rewardsWeekendRate;

    public Hotel(String name, int weekdayRate, int weekendRate, int rating, int rewardsWeekdayRate, int rewardsWeekendRate) {
        this.name = name;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
        this.rating = rating;
        this.rewardsWeekdayRate = rewardsWeekdayRate;
        this.rewardsWeekendRate = rewardsWeekendRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeekdayRate() {
        return weekdayRate;
    }

    public void setWeekdayRate(int weekdayRate) {
        this.weekdayRate = weekdayRate;
    }

    public int getWeekendRate() {
        return weekendRate;
    }

    public void setWeekendRate(int weekendRate) {
        this.weekendRate = weekendRate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRewardsWeekdayRate() {
        return rewardsWeekdayRate;
    }

    public void setRewardsWeekdayRate(int rewardsWeekdayRate) {
        this.rewardsWeekdayRate = rewardsWeekdayRate;
    }

    public int getRewardsWeekendRate() {
        return rewardsWeekendRate;
    }

    public void setRewardsWeekendRate(int rewardsWeekendRate) {
        this.rewardsWeekendRate = rewardsWeekendRate;
    }
}
