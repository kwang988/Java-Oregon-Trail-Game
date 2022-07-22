package com.kenzie.library;

public class Wagon {
    //declare properties
    private int capacity;
    private Traveler[] passengers;

    //declare constructor
    public Wagon(int capacity) {
        this.capacity = capacity;
        this.passengers = new Traveler[capacity];
    }

    //declare methods
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Traveler[] getPassengers() {
        return passengers;
    }

    public void setPassengers(Traveler[] passengers) {
        this.passengers = passengers;
    }

    public int getAvailableSeatCount() {
        int openSeats = 0;
        //loop through passengers, check for null
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] == null) {
                openSeats += 1;
            }
        }
        return openSeats;
    }

    public void join(Traveler traveler) {
        //loop through wagon and add traveler if there is space
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] == null) {
                passengers[i] = traveler;
                break;
            }
        }
    }

    public boolean shouldQuarantine() {
        boolean isSick = false;
        for (Traveler traveler : passengers) {
            if (traveler != null) {
                if (!traveler.getIsHealthy()) {
                    isSick = true;
                }
            }
        }
        return isSick;
    }

    public int totalFood() {
        int foodSum = 0;
        for (int i = 0; i < passengers.length; i++) {
            if (!(passengers[i] == null)) {
                foodSum += passengers[i].getFood();
            }
        }
        return foodSum;
    }

    public void loadWagon (int numTravelers, int numHunters, int numDoctors) {
            for (int i = 0; i < numTravelers; i++) {
                Traveler traveler = new Traveler();
                if (this.getAvailableSeatCount() > 0) {
                    this.join(traveler);
                }
            }
            for (int i = 0; i < numHunters; i++) {
                Hunter hunter = new Hunter();
                if (this.getAvailableSeatCount() > 0) {
                    this.join(hunter);
                }
            }
            for (int i = 0; i < numDoctors; i++) {
                Doctor doctor = new Doctor();
                if (this.getAvailableSeatCount() > 0) {
                    this.join(doctor);
                }
            }
    }


}
