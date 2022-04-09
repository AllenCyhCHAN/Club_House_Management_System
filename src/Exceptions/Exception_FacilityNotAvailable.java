package Exceptions;

public class Exception_FacilityNotAvailable extends RuntimeException{
  public Exception_FacilityNotAvailable() {
    super("This facility is occupied.");
  }
}