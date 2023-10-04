/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0055;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validate {

    private final static Scanner in = new Scanner(System.in);
    static final String CODE_VALID = "(?i)[DOC]{3}[0-9]+";
    static final String NAME_VALID = "[a-zA-Z ]+";
    static final String SPECIALIZATION_VALID = "[a-zA-Z]+";

    public static int getInputIntLimit(String Mess, int min, int max) {
        System.out.println(Mess);
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input a number in range [" + min + ", " + max + "]");
                System.out.print("Enter choice again: ");
            }
        }
    }

    public static String getString(String error, String regex) {
        while (true) {
            String input = in.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty!");
                System.out.print("Enter again: ");
            } else {
                if (input.matches(regex)) {
                    return input;
                } else {
                    System.out.println(error);
                }
            }
        }
    }
    public static String getStringSearchDoctor() {
    while (true) {
        System.out.print("Enter name Doctor to search (leave blank to show all): ");
        String input = in.nextLine().trim();

        if (input.isEmpty()) {
            // Nếu người dùng không nhập gì, trả về chuỗi rỗng để hiển thị tất cả dữ liệu
            return input;
        } else if (input.matches(NAME_VALID)) {
            // Nếu tên hợp lệ, trả về tên
            return input;
        } else {
            System.out.println("Invalid name. Please enter a valid name.");
        }
    }
}


    public static String getUpdateString(String regex) {
 
        String input = in.nextLine();
        // Kiểm tra nếu người dùng không nhập gì (chuỗi rỗng)
        if (input.isEmpty()) {
            // Trả về chuỗi rỗng để chỉ định không có thay đổi
            return input;
        }
        // Kiểm tra nếu đầu vào khớp với regex đã chỉ định
        if (input.matches(regex)) {
            // Trả về đầu vào nếu nó khớp với regex
            return input;
        } else {
            // In thông báo lỗi nếu đầu vào không khớp với regex
            System.out.println("Invalid Input");
            // Trả về chuỗi rỗng để chỉ định một đầu vào không hợp lệ
            return "";
        }
    }
   
    public static int getUpdateInt() {
  
        String input = in.nextLine();

        // Kiểm tra nếu người dùng không nhập gì (chuỗi rỗng)
        if (input.isEmpty()) {
            // Trả về -1 để chỉ định không có thay đổi
            return -1;
        }

        try {
            // chuyển đổi đầu vào thành một số nguyên
            int num = Integer.parseInt(input);
            // Trả về số nguyên đã chuyển đổi
            return num;
        } catch (NumberFormatException e) {
            // In thông báo lỗi nếu đầu vào không thể chuyển đổi thành số nguyên
            System.out.println("Invalid input");
            // Trả về -1 để chỉ định một đầu vào không hợp lệ
            return -1;
        }
    }

    public static int checkAvailability() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result >= 0) {
                    return result;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("Availability mush be positive integer");
                System.out.print("Enter again: ");
            }
        }
    }

}
