package com.matchmaker.api;

public class MatchingPoints {

    User user;
    int hobbiesPoints;
    int professionPoints;
    int nearbyDistrictPoints;
    int totalPoints;

    public MatchingPoints() {
    }

    public MatchingPoints(User user, int hobbiesPoints, int professionPoints, int nearbyDistrictPoints, int totalPoints) {
        this.user = user;
        this.hobbiesPoints = hobbiesPoints;
        this.professionPoints = professionPoints;
        this.nearbyDistrictPoints = nearbyDistrictPoints;
        this.totalPoints = totalPoints;
    }
    public MatchingPoints(User user, int hobbiesPoints, int professionPoints , int nearbyDistrictPoints) {
        this.user = user;
        this.hobbiesPoints = hobbiesPoints;
        this.professionPoints = professionPoints;
        this.nearbyDistrictPoints = nearbyDistrictPoints;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getHobbiesPoints() {
        return hobbiesPoints;
    }

    public void setHobbiesPoints(int hobbiesPoints) {
        this.hobbiesPoints = hobbiesPoints;
    }

    public int getProfessionPoints() {
        return professionPoints;
    }

    public void setProfessionPoints(int professionPoints) {
        this.professionPoints = professionPoints;
    }

    public int getNearbyDistrictPoints() {
        return nearbyDistrictPoints;
    }

    public void setNearbyDistrictPoints(int nearbyDistrictPoints) {
        this.nearbyDistrictPoints = nearbyDistrictPoints;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    @Override
    public String toString() {
        return "MatchingPoints{" +
                "user=" + user +
                ", hobbiesPoints=" + hobbiesPoints +
                ", professionPoints=" + professionPoints +
                ", nearbyDistrictPoints=" + nearbyDistrictPoints +
                ", totalPoints=" + totalPoints +
                '}';
    }
}
