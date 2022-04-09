package Data;

import java.util.*;
import java.io.*;

public class Staff {
    static String headerText, staffString[], headerArray[];
    static String line = "", temp = "", separator = "###;###";
    static int dataCounter = 0, staffCounter = 0;
    private static String id, password;
    private static String staffLoginData[][];
    
    //setter and getter 
    public static void setId(String id){
        Staff.id = id;
    }
    public static String getId(){
        return id;
    }

    public static void setPassword(String password){
        Staff.password = password;
    }
    public static String getPassword(){
        return password;
    }

    // loging chcking method
    //returns -1 when loging is invalid, 0 when normal staff login, 1 when manager manager login
    public static int StaffChecking(String staffPath) throws Exception {
        File file = new File(staffPath);
        Scanner scanner_staff = new Scanner(file);
        //scan the CSV
        for (int i = 0; scanner_staff.hasNextLine(); i++) {
            line = scanner_staff.nextLine();
            if (i == 0) {
                headerText = line;
                headerArray = headerText.split(",");
                dataCounter = (headerArray.length);
            } else {
                temp = temp + line + separator; //Staff data
            }
        }
        staffString = temp.split(separator);
        staffCounter = staffString.length;
        staffLoginData = new String[staffCounter][dataCounter];
        for (int j = 0; j < staffCounter; j++) {
            staffLoginData[j] = staffString[j].split(",");
        }

        //Check whether id,pw are matching , while also check their identity
        for (int k = 0; k < staffCounter; k++){
            if (getId().equals(staffLoginData[k][0])){
                if (getPassword().equals(staffLoginData[k][2])) {
                    if (staffLoginData[k][3].equals("Manager")) {
                      scanner_staff.close();
                      return 1;
                    } else {
                      scanner_staff.close();
                      return 0;  
                    }
                }
            }
        }
        scanner_staff.close();
        return -1;
    }
}
