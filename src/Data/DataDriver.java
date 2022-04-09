package Data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


public class DataDriver {
  private ArrayList<Facility> facilityArrayList;
  private ArrayList<Member> memberArrayList;
  private ArrayList<Reservation> reservationArrayList;

  private File facilityFile;
  private File memberFile;
  private File reservationFile;

  //-----------------------------------------------------------------------------------------
  // scan method to get data from the CSV
  public DataDriver(String facilityPath, String memberPath, String reservationPath) {
    facilityFile = new File(facilityPath);
    memberFile = new File(memberPath);
    reservationFile = new File(reservationPath);

    facilityArrayList = new ArrayList<Facility>();
    memberArrayList = new ArrayList<Member>();
    reservationArrayList = new ArrayList<Reservation>();
    //scan through the MemberCSV and store all data to arraylist 
    Scanner scanner_MemberFile;
    try {
      scanner_MemberFile = new Scanner(memberFile);
      for (int i = 0; scanner_MemberFile.hasNextLine(); i++) {
        String line = scanner_MemberFile.nextLine();
        //skip for row 1 which are the column titles
        if (i == 0) {
        } else {
          String[] cells = line.split(",");
          memberArrayList.add(new Member(Integer.parseInt(cells[0]),cells[1], Integer.parseInt(cells[2]), cells[3], cells[4]));
        }
      }
      scanner_MemberFile.close();
    } 
    //create a csv file with preset title if file was not found 
    catch (FileNotFoundException e) {
      BufferedWriter writer;
      try {
        writer = new BufferedWriter(new FileWriter(this.memberFile, false));
        writer.write("memberID,memberName,memberPhone,memberAddress,memberEmail\n");
        writer.close();
      } catch (IOException exeception2) {
        exeception2.printStackTrace();}
    }
    //scan through the FacilityCSV and store all data to arraylist
    Scanner scanner_FacilityFile;
    try {
      scanner_FacilityFile = new Scanner(facilityFile);
      for (int i = 0; scanner_FacilityFile.hasNextLine(); i++) {
        String line = scanner_FacilityFile.nextLine();
        //skip for row 1 which are the column titles
        if (i == 0) {
        } else {
          String[] cells = line.split(",");
          facilityArrayList.add(new Facility(Integer.parseInt(cells[0]),
                  cells[1],
                  Integer.parseInt(cells[2]),
                  Integer.parseInt(cells[3]),
                  Integer.parseInt(cells[4]),cells[5],
                  Boolean.valueOf(cells[6])));
        }
      }
      scanner_FacilityFile.close();
    } catch (FileNotFoundException e) {
    //create a csv file with preset title if file was not found
      BufferedWriter writer;
      try {
        writer = new BufferedWriter(new FileWriter(this.facilityFile, false));
        writer.write("facilityID,facilityName,rent,openTime,closeTime,descriptions,status\n");
        writer.close();
      } catch (IOException exception3) {
        exception3.printStackTrace();
      }

    }
    //scan through the reservationCSV and store all data in arraylist 
    Scanner reservationScanner;
    try {
      reservationScanner = new Scanner(reservationFile);
      for (int i = 0; reservationScanner.hasNextLine(); i++) {
        String line = reservationScanner.nextLine();
        if (i == 0) {
        //skip for row 1 which are the column titles
        } else {
          String[] cells = line.split(",");
          reservationArrayList.add(new Reservation(Integer.parseInt(cells[0]),
                  findMemberWithID(Integer.parseInt(cells[1])),
                  findFacilityWithID(Integer.parseInt(cells[2])),
                  LocalDate.parse(cells[3]),
                  Integer.parseInt(cells[4]),
                  cells[5]
                  ));
          updateReservationFile();
        }
      }
      reservationScanner.close();
    } catch (FileNotFoundException e) {
    //create a csv file with preset title if file was not found
      BufferedWriter writer;
      try {
        writer = new BufferedWriter(new FileWriter(this.reservationFile, false));
        writer.write("reservationID,memberID,facilityID,date,time,status\n");
        writer.close();
      } catch (IOException exeception4) {
        // TODO Auto-generated catch block
        exeception4.printStackTrace();
      }    }
  }
//----------------------------------------------------------------------------------------------------------
  //Getter of 3 data arraylist
  public ArrayList<Facility> getFacilityArrayList() {
    return this.facilityArrayList;
  }
  public ArrayList<Member> getMemberArrayList() {
    return this.memberArrayList;
  }
  public ArrayList<Reservation> getReservationArrayList() {
    return this.reservationArrayList;
  }

//---------------------------------------------------------------------------------------------------------
  // method for updating the CSV after changing the Arraylist
  public void updateMemberFile() {
    ArrayList<String[]> lines = new ArrayList<String[]>();
    // loop through arraylist and store to a new arraylist
    for (int i = 0; i < this.memberArrayList.size(); i++) {
      Member targetMember = memberArrayList.get(i);
      String[] newLine = {
        Integer.toString(targetMember.getMemberID()),
        targetMember.getMemberName(),
        Integer.toString(targetMember.getMemberPhone()),
        targetMember.getMemberAddress(),
        targetMember.getMemberEmail()+"\n"
      };
      lines.add(newLine);
    }
    // write the tilte and items in the arraylist to the csv
    BufferedWriter writer;
    try {
      writer = new BufferedWriter(
              new FileWriter(this.memberFile, false));
      writer.write("memberID,memberName,memberPhone,memberAddress,memberEmail\n");
      for (int i = 0; i < lines.size(); i++) {
        String[] currentLine = lines.get(i);
        for (int j = 0; j < currentLine.length; j++) {
          writer.write(currentLine[j]);
          // add delimeter except the last item
          if (j != currentLine.length-1) {
            writer.write(",");
          }
        }
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  // method for updating the CSV after changing the Arraylist
  public void updateFacilityFile() {
    ArrayList<String[]> lines = new ArrayList<String[]>();
        // loop through arraylist and store to a new arraylist

    for (int i = 0; i < this.facilityArrayList.size(); i++) {
      Facility targetFacility = facilityArrayList.get(i);
      String[] line = {
              Integer.toString(targetFacility.getFacilityID()),
              targetFacility.getFacilityName(),
              Integer.toString(targetFacility.getRent()),
              Integer.toString(targetFacility.getOpeningHour()),
              Integer.toString(targetFacility.getClosingHour()),
              targetFacility.getDescription(),
              Boolean.toString(targetFacility.getStatus())+"\n"
      };
      lines.add(line);
    }
    // write the tilte and items in the arraylist to the csv
    BufferedWriter writer;
    try {
      writer = new BufferedWriter(
              new FileWriter (this.facilityFile, false)
      );
      writer.write("facilityID,facilityName,rent,openTime,closeTime,descriptions,status\n");
      for (int i = 0; i < lines.size(); i++) {
        String[] line = lines.get(i);
        for (int j = 0; j < line.length; j++) {
          writer.write( line[j]);
          // add delimeter except the last item
          if (j != line.length-1) {
            writer.write(",");
          }
        }
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void updateReservationFile() {
    ArrayList<String[]> lines = new ArrayList<String[]>();

    for (int i = 0; i < this.reservationArrayList.size(); i++) {
      Reservation targetReservation = reservationArrayList.get(i);
      String[] line = {
        Integer.toString(targetReservation.getReservationID()),
        Integer.toString(targetReservation.getReservation_MemberID()),
        Integer.toString(targetReservation.getReservation_FacilityID()),
        targetReservation.getDate().toString(),
        Integer.toString(targetReservation.getTime()),
        targetReservation.getStatus()+"\n"
      };
      lines.add(line);
    }
    // write the tilte and items in the arraylist to the csv
    BufferedWriter writer;
    try {
      writer = new BufferedWriter(new FileWriter(this.reservationFile, false));
      writer.write("reservationID,memberID,facilityID,date,time,status\n");
      for (int i = 0; i < lines.size(); i++) {
        String[] currentLine = lines.get(i);
        for (int j = 0; j < currentLine.length; j++) {
          writer.write(currentLine[j]);
          // add delimeter except the last item
          if (j != currentLine.length-1) {
            writer.write(",");
          }
        }
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
//-----------------------------------------------------------------------------------------------
// method of searching data using different attributes
  // search using memberid
  public Member findMemberWithID(int id) {
    for (int i = 0; i <this.memberArrayList.size(); i++) {
      Member targetMember = this.memberArrayList.get(i);
      if (targetMember.getMemberID() == id) {
        return targetMember;
      }
    }
    return null;
  }
  // search using phone number
  public Member findMemberWithPhone(int phone) {
    for (int i = 0; i <this.memberArrayList.size(); i++) {
      Member targetMember = this.memberArrayList.get(i);
      if (targetMember.getMemberPhone() == phone) {
        return targetMember;
      }
    }
    return null;
  }
  // serarch using reservation id 
  public Reservation findReservationWithID(int id) {
    for (int i = 0; i < this.reservationArrayList.size(); i++) {
      Reservation targetReservation = this.reservationArrayList.get(i);
      if (targetReservation.getReservationID() == id) {
        return targetReservation;
      }
    }
    return null;
  }
  // search using facility id 
  public Facility findFacilityWithID(int id) {
    for (int i = 0; i < this.facilityArrayList.size(); i++) {
      Facility targetFacility = this.facilityArrayList.get(i);
      if (targetFacility.getFacilityID() == id) {
        return targetFacility;
      }
    }
    return null;
  }

//---------------------------------------------------------------------------------------------------------------
  //Methods of adding new data to the arraylist 
  
  public void createMember(String memberName, int memberPhone, String memberAddress, String memberEmail) {
    int newId = 0;
    if (memberArrayList.size()>0) {
      // new id  = the id of the last id +1 
      newId = memberArrayList.get(memberArrayList.size()-1).getMemberID()+1;
    } 
    memberArrayList.add(new Member(newId, memberName, memberPhone, memberAddress, memberEmail));
    //update the csv after adding data
    updateMemberFile();
  }

  public void createFacility(String facilityName, int rent, int openTime, int closeTime, String descriptions) {
      // new id  = the id of the last id +1 
    int newId = 0;
    if (facilityArrayList.size()>0) {
      newId = facilityArrayList.get(facilityArrayList.size()-1).getFacilityID()+1;
    }
    facilityArrayList.add(new Facility(newId, facilityName, rent, openTime, closeTime, descriptions, false));
        //update the csv after adding data
    updateFacilityFile();
  }

  public void createReservation(int memberID, int facilityID, LocalDate date, int time) {
        // new id  = the id of the last id +1 
    int newId = 0;
    if (reservationArrayList.size()>0) {
      newId = reservationArrayList.get(reservationArrayList.size()-1).getReservationID()+1;
    }

// using search method to look for the correalated memberID and facility ID
    Facility facility = findFacilityWithID(facilityID);
    Member member = findMemberWithID(memberID);

    reservationArrayList.add(new Reservation(newId, member, facility, date, time, "Booked"));
         //update the csv after adding data
    updateReservationFile();
  }
  
//------------------------------------------------------------------------------------------------------------------
  //method for removing the data 

  public void deleteMember(int id) {
    // search for the member needed to be deleted
    Member selectedMember = findMemberWithID(id);
    ArrayList<Reservation> relatedReservations = selectedMember.getReservations();

    // delete the reservation of the member also
    for (int i = 0; i < relatedReservations.size(); i++) {
      Reservation currentReservation = relatedReservations.get(i);
      deleteReservation(currentReservation.getReservationID());
    }
    //remove member from the list
    this.memberArrayList.remove(selectedMember);
    //update the CSV
    updateMemberFile();
  }

  public void deleteFacility(int id) {
   // search for the facility needed to be deleted
    Facility selectedFacility = findFacilityWithID(id);
    ArrayList<Reservation> relatedReservations = selectedFacility.getReservations();

    // delete the reservation related to the faciltiy alsp
    for (int i = 0; i < relatedReservations.size(); i++) {
      Reservation currentReservation = relatedReservations.get(i);
      deleteReservation(currentReservation.getReservationID());
    }
    // remove the facility from the list
    this.facilityArrayList.remove(selectedFacility);
    //update the CSV
    updateFacilityFile();
  }

  public void deleteReservation(int id) {
    // search for the reservation
    Reservation selectedReservation = findReservationWithID(id);
    //delte the reservation from the list
    this.reservationArrayList.remove(selectedReservation);
    //update the CSV
    updateReservationFile();
  }

//----------------------------------------------------------------------------------------------
  // method for modifying the data 
  
  public void modifyMember(int memberID, String newMemberName, int newMemberPhone, String newMemberAddress, String newMemberEmail) {
    //search the member 
    Member targetMember = findMemberWithID(memberID);
    // set the new attributes
    targetMember.setMemberName(newMemberName);
    targetMember.setMemberPhone(newMemberPhone);
    targetMember.setMemberAddress(newMemberAddress);
    targetMember.setMemberEmail(newMemberEmail);
    //update CSV
    updateMemberFile();
  }

  public void modifyFacility(int facilityID, String newFacilityName, int newRent, int newOpenTime, int newCloseTime, String newDescriptions) {
    // search the facility 
    Facility targetFacility = findFacilityWithID(facilityID);
    // set the new attributes
    targetFacility.updateFacility(newFacilityName,newRent,newOpenTime,newCloseTime,newDescriptions);
    // update CSV
    updateFacilityFile();
  }
  
  //------------------------------------------------------------------------------------------------------------

  // method for changing the status of both reservation and facility when checkin
  public void checkIn(int id_Reservation) {
    // find the related facility and reservation
    Reservation targetReservation = findReservationWithID(id_Reservation);
    Facility targetFacility = findFacilityWithID(targetReservation.getReservation_FacilityID());
    try {
      // trigger reservation chechIn method to change stauts
      targetReservation.checkIn();
    } catch (Exception e) {
      e.printStackTrace();
    }
    // change facility status 
    targetFacility.setStatus(true);
    //update CSV
    updateFacilityFile();
    updateReservationFile();
  }

  // method for changing the status of both reservation and facility when checkout
  public void checkOut(int id_Reservation) {
    // find the realted facility and reservation
    Reservation targetReservation = findReservationWithID(id_Reservation);
    Facility targetFacility = findFacilityWithID(targetReservation.getReservation_FacilityID());
    try {
      // trigger reservation checkout method to change stauts 
      targetReservation.checkOut();
    } catch (Exception e) {
      e.printStackTrace();
    }
    //change facility status
    targetFacility.setStatus(false);
    //update CSV
    updateFacilityFile();
    updateReservationFile();
  }


  //Find available timeslots of a facility 
  public ArrayList<Integer> facility_Availability_ArrayList(int facilityID, LocalDate date) {
    Facility targetFacility = findFacilityWithID(facilityID);
    return targetFacility.retrieveAvailableTime(date);}

  //Check booking 
  public ArrayList<Boolean> checkFacilityCurrentBooking() { 
    // get the time now
    LocalDateTime currentDateTime  = LocalDateTime.now();
    int currentHour = currentDateTime.getHour();
    // check all faciltiy and store the bollean value in the arraylist
    ArrayList<Boolean> booleanArrayList = new ArrayList<Boolean>(); 
    for (int i = 0; i < facilityArrayList.size(); i++) {
      Facility currentFacility = facilityArrayList.get(i);
      //check availiblilty
      booleanArrayList.add(currentFacility.checkTimeslotBooked(currentDateTime.toLocalDate(), currentHour));
    }
    return booleanArrayList;
  }

  //Check facility usage 
  public ArrayList<Boolean> checkFacilityInUse() {
    ArrayList<Boolean> booleanArrayList = new ArrayList<Boolean>();
    for (int j = 0; j < facilityArrayList.size(); j++) {
      // checl all facility and store the status value in the new arraylist 
      Facility currentFacility = facilityArrayList.get(j);
      booleanArrayList.add(currentFacility.getStatus());
    }
    return booleanArrayList;
  }
}