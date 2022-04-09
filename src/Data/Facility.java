package Data;

import java.time.LocalDate;
import java.util.ArrayList;

public class Facility implements Comparable<Facility>{
  final private int facilityID;
  private String facilityName;
  private int rent;
  private int openingHour; 
  private int ClosingHour; 
  private String description;
  private ArrayList<Reservation> reservationArrayList_InFacility;
  private boolean status;

  //constructor
  Facility(int facilityID, String facilityName, int rent, int openingHour, int ClosingHour, String description, Boolean status) {
    this.facilityID = facilityID;
    this.facilityName = facilityName;
    this.rent = rent;
    this.openingHour = openingHour;
    this.ClosingHour = ClosingHour;
    this.description = description;
    this.reservationArrayList_InFacility = new ArrayList<Reservation>();
    this.status = status;
  }
 
  //Setter
  public int getFacilityID() {
    return this.facilityID;
  }

  public void setFacilityName(String newFacilityName) {
    this.facilityName = newFacilityName;
  }
  public String getFacilityName() {
    return this.facilityName;
  }

  public void setRent(int newRent) {
    this.rent = newRent;
  }
  public int getRent() {
    return this.rent;
  }

  public void setOpeningHour(int newOpenTime) {
    this.openingHour = newOpenTime;
  }
  public int getOpeningHour() {
    return this.openingHour;
  }

  public void setClosingHour(int newCloseTime) {
    this.ClosingHour = newCloseTime;
  }
  public int getClosingHour() {
    return this.ClosingHour;
  }

  public void setDescription(String newDescriptions) {
    this.description = newDescriptions;
  }
  
  //getter
  public String getDescription() {
    return this.description;
  }

  public void setStatus(boolean newStatus) {
    this.status = newStatus;
  }
  public boolean getStatus() {
    return this.status;
  }


  //get reservation list
  public ArrayList<Reservation> getReservations() {
    return this.reservationArrayList_InFacility;
  }

  // insert new reservation to the list
  public void addReservation(Reservation newReservation) {
    this.reservationArrayList_InFacility.add(newReservation);
  }

  //method for getting the reservation on a specific date
  public ArrayList<Reservation> getReservationsOnDate(LocalDate date) {
    ArrayList<Reservation> reservationsOnDate = new ArrayList<Reservation>();
    for (int i = 0; i < this.reservationArrayList_InFacility.size(); i++) {
      Reservation currentReservation = reservationArrayList_InFacility.get(i);
      if (currentReservation.getDate().isEqual(date)) {
        reservationsOnDate.add(currentReservation);
      }
    }
    return reservationsOnDate;
  }

  //edit facility
  public void updateFacility(String newFacilityName, int newRent, int newOpenTime, int newCloseTime, String newDescriptions){
    this.setFacilityName(newFacilityName);
    this.setRent(newRent);
    this.setOpeningHour(newOpenTime);
    this.setClosingHour(newCloseTime);
    this.setDescription(newDescriptions);
  }


  public Boolean checkTimeslotBooked(LocalDate date, int time) {
    Boolean bookedOrNot = false;
    for (int j = 0; j < this.reservationArrayList_InFacility.size(); j++) {
      Reservation currentReservation = reservationArrayList_InFacility.get(j);
      if (currentReservation.getDate().equals(date)) {
        if (currentReservation.getTime() == time) {
          bookedOrNot = true;
        }
      }
    }
    return bookedOrNot;
  }

//get available time slot 
  public ArrayList<Integer> retrieveAvailableTime(LocalDate date) {
    ArrayList<Integer> availableTimeList = new ArrayList<Integer>();
   // normal situation
    if (this.openingHour < this.ClosingHour) {
      for (int i = this.openingHour; i < this.ClosingHour; i++) {
        availableTimeList.add(i);
      }
    } else if (this.openingHour > this.ClosingHour){
      // if the facility open overnight 
      for (int i = this.openingHour; i < 24; i++) {
        availableTimeList.add(i);
      }
      for (int i = 0; i < this.ClosingHour; i++) {
        availableTimeList.add(i);
      }
    } else {
      //if the facility open 24 hours
      for (int i = 0; i < 24; i++) {
        availableTimeList.add(i);
      }
    }
    
    //Remove booked timeslots from the list
    ArrayList<Reservation> reservationsOnDate = this.getReservationsOnDate(date);
    
    if (reservationsOnDate != null) {
      for (int i = 0; i < reservationsOnDate.size(); i++) {
        Reservation currentReservation = reservationsOnDate.get(i);
        availableTimeList.remove(Integer.valueOf(currentReservation.getTime()));
      }
      return availableTimeList;
    } else {
      return availableTimeList;
    }
  }

  
  
  public ArrayList<Reservation> getPreviousMonthReservation() {
    ArrayList<Reservation> reservation_PreviousMonth = new ArrayList<Reservation>();
    for (int i = 0; i < this.reservationArrayList_InFacility.size(); i++) {
      Reservation currentReservation = this.reservationArrayList_InFacility.get(i);
      if (currentReservation.getDate().isBefore(LocalDate.now()) & (currentReservation.getDate().isAfter(LocalDate.now().minusDays(30)))) {
        reservation_PreviousMonth.add(currentReservation);
      }
    }
    return reservation_PreviousMonth;
  }
  
  
  
  //calculate utilization rate
  public double getUtilisationRate_PreviousMonth() {
    ArrayList<Reservation> reservations_PreviousMonth = this.getPreviousMonthReservation();
    double totalOpeningHours;
    if (this.openingHour == 0 && this.ClosingHour == 0){
      totalOpeningHours = new Double(24*30);
    }
    else if (this.openingHour > this.ClosingHour) {
      totalOpeningHours = new Double(((this.ClosingHour -0) + (24 - this.openingHour))*30);
    }
    else {
      totalOpeningHours = new Double((this.ClosingHour - this.openingHour)*30);
    }
    double utilisedHours = new Double(reservations_PreviousMonth.size());
    return utilisedHours/totalOpeningHours;
  }

  //compare the number of reservations
  @Override
  public int compareTo(Facility facility) {
    //Compare
    if (facility.getUtilisationRate_PreviousMonth() > this.getUtilisationRate_PreviousMonth()) {
      return 1;
    } else {
      if (facility.getUtilisationRate_PreviousMonth() < this.getUtilisationRate_PreviousMonth()) {
        return -1;
      } else {
        return 0;
      }
    }
  }
}