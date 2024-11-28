package com.lina.airline.enums;

public enum SeatType {
    ECONOMY,
    BUSINESS;

    @Override
    public String toString() {
        return name(); // Return the name of the enum constant
    }

    // Optional: Custom method to return uppercase (redundant in this case)
    public String toUpperCase() {
        return name().toUpperCase(); // Ensure it's uppercase
    }
}
