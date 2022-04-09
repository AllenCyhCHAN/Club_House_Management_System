package Data;

import java.time.LocalDate;
import Exceptions.*;


public class Reservation {
  final private int reservationID;
  final private int reservation_MemberID;
  final private int reservation_FacilityID;
  final private LocalDate date;
  final private int time;
  private String status;

  //constructor
  Reservation(int reservationID, Member member, Facility facility, LocalDate date, int time, String status) {
    this.reservationID = reservationID;
    this.reservation_MemberID = member.getMemberID();
    this.reservation_FacilityID = facility.getFacilityID();
    this.date = date;
    this.time = time;
    this.status = status;

    facility.addReservation(this);
    member.addReservation(this);
  }

  //getter
  public int getReservationID() {
    return this.reservationID;
  }

  public int getReservation_MemberID() {
    return this.reservation_MemberID;
  }

  public int getReservation_FacilityID() {
    return this.reservation_FacilityID;
  }

  public LocalDate getDate() {
    return this.date;
  }

  public int getTime() {
    return this.time;
  }

  public String getStatus() {
    return this.status;
  }

  // checkin 
  public void checkIn() {
    if (this.status.equals("Checked In")) {
      throw new Exception_CheckInAlready();
    } else if (this.status.equals("Checked Out")){
        throw new Exception_CheckOutAlready();
    } else {
        this.status = "Checked In";
    }
  }

  // checkout
  public void checkOut() {
    if (this.status.equals("Booked")){
        throw new Exception_NotYetCheckIn();
    } else if (this.status.equals("Checked Out")){
        throw new Exception_CheckOutAlready();
    } else {
        this.status = "Checked Out";
    }
  }


}