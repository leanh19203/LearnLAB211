/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0055;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Doctor> data = new ArrayList<>();
        data.add(new Doctor("doc1", "DucAnh", "DaKhoa", 99));
        data.add(new Doctor("doc2", "Minh", "khoasan", 60));
        data.add(new Doctor("doc3", "Khoa", "Khoanoi", 78));
        
        while (true) {
             //display menu
            System.out.println("========== Doctor Management ==========\n"
                    + "1.  Add Doctor\n"
                    + "2.  Update Doctor\n"
                    + "3.  Delete Doctor\n"
                    + "4.  Search Doctor\n"
                    + "5.  Exit \n"
                    + "=======================================\n");
        
            int choice = Validate.getInputIntLimit("Enter your choice: ",1, 5);
            switch (choice) {
                case 1:
                    ManagerDoctor.addDoctor(data);
                    break;
                case 2:
                    ManagerDoctor.updateDoctor(data);
                    break;
                case 3:
                    ManagerDoctor.deleteDoctor(data);
                    break;
                case 4:
                    ManagerDoctor.searchDoctor(data);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);
            }
        }
    }
}
