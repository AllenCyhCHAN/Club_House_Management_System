package Data;

import java.time.LocalDate;
import java.util.ArrayList;


public class Member {
  final private int memberID;
  private String memberName;
  private int memberPhone;
  private String memberAddress;
  private String memberEmail;
  private ArrayList<Reservation> reservationArrayList_InMember;

  //constructor
  Member(int id, String name, int phone, String address, String email) {
    this.memberID = id;
    this.memberName = name;
    this.memberPhone = phone;
    this.memberAddress = address;
    this.memberEmail = email;
    this.reservationArrayList_InMember = new ArrayList<Reservation>();
  }
 
  // getter and setter
  public int getMemberID() {
    return this.memberID;
  }

  public void setMemberName(String newMemberName) {
    memberName = newMemberName;
  }
  public String getMemberName() {
    return this.memberName;
  }

  public void setMemberPhone(int newMemberPhone) {
    memberPhone = newMemberPhone;
  }
  public Integer getMemberPhone() {
    return this.memberPhone;
  }

  public void setMemberAddress(String newMemberAddress) {
    memberAddress = newMemberAddress;
  }
  public String getMemberAddress() {
    return this.memberAddress;
  }

  public void setMemberEmail(String newMemberEmail) {
    memberEmail = newMemberEmail;
  }
  public String getMemberEmail() {
    return this.memberEmail;
  }

  public void addReservation(Reservation newReservation) {
    reservationArrayList_InMember.add(newReservation);
  }
  public ArrayList<Reservation> getReservations() {
    return this.reservationArrayList_InMember;
  }


  //Method for getting the reservation on a date
  public ArrayList<Reservation> getReservations_WithDate(LocalDate date) {
    ArrayList<Reservation> reservationArrayList_OfDate = new ArrayList<Reservation>();
    for (int j = 0; j < this.reservationArrayList_InMember.size(); j++) {
      Reservation currentReservation = reservationArrayList_InMember.get(j);
      if (currentReservation.getDate().isEqual(date)) {
        reservationArrayList_OfDate.add(currentReservation);
      }
    }
    return reservationArrayList_OfDate;
  }

  //Check if member has booked another facility in the same time , true if there are time clashes
  
  public Boolean checkTimeslotAvailability(LocalDate date, int time) {
    Boolean notAvailable = false;
    
    //get reservations on that date
    ArrayList<Reservation>reservationsOnDate = this.getReservations_WithDate(date);
    
    //check all reservtion on that day
    for (int i = 0; i < reservationsOnDate.size(); i++) {
      Reservation currentReservation = reservationsOnDate.get(i);
      if (currentReservation.getTime() == time) {
        notAvailable = true;
        break;
      }
    }
    return notAvailable;
  }
}
