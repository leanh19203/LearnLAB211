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
public class ManagerDoctor {

    //allow user add doctor
    public static void addDoctor(ArrayList<Doctor> data) {
        System.out.println("---------- Add Doctor ----------");
        System.out.print("Enter code Doctor: ");
        String code = Validate.getString(" Code must be docx or DOCx Enter again:", Validate.CODE_VALID);

        if (checkCodeExist(data, code)) {
            System.err.println("Code already exists.");
            return;
        }

        System.out.print("Enter name Doctor: ");
        String name = Validate.getString("Invalid name Enter again:", Validate.NAME_VALID);
        System.out.print("Enter specialization: ");
        String specialization = Validate.getString("Invalid specialization Enter again:", Validate.SPECIALIZATION_VALID);
        System.out.print("Enter availability: ");
        int availability = Validate.checkAvailability();
        data.add(new Doctor(code, name, specialization, availability));
        System.err.println("Add successful.");

    }

    public static void updateDoctor(ArrayList<Doctor> data) {
        System.out.println("---------- Update Doctor ----------");

        System.out.print("Enter code Doctor to Update: ");
        String code = Validate.getString("Invalid code Enter again:", Validate.CODE_VALID);
        // Lấy đối tượng Doctor tương ứng với mã đã nhập
        Doctor doctor = getDoctorByCode(data, code);

        // Kiểm tra nếu không tìm thấy bác sĩ
        if (doctor == null) {
            System.err.println("Doctor not found.");
            return;  // Kết thúc phương thức nếu không tìm thấy bác sĩ
        }

        // Yêu cầu người dùng nhập thông tin mới cho tên bác sĩ (để trống nếu không muốn thay đổi)
        System.out.print("Enter new name Doctor (leave blank for no change): ");
        String nameUpdate = Validate.getUpdateString(Validate.NAME_VALID);

        // Nếu người dùng đã nhập tên mới, cập nhật thông tin tương ứng
        if (!nameUpdate.isEmpty()) {
            doctor.setName(nameUpdate);
        }

        // Yêu cầu người dùng nhập thông tin mới cho chuyên khoa (để trống nếu không muốn thay đổi)
        System.out.print("Enter new specialization (leave blank for no change): ");
        String specializationUpdate = Validate.getUpdateString(Validate.SPECIALIZATION_VALID);

        // Nếu người dùng đã nhập chuyên khoa mới, cập nhật thông tin tương ứng
        if (!specializationUpdate.isEmpty()) {
            doctor.setSpecialization(specializationUpdate);
        }

        // Yêu cầu người dùng nhập thông tin mới cho sẵn có (để trống nếu không muốn thay đổi)
        System.out.print("Enter new availability (leave blank for no change): ");
        int availabilityUpdate = Validate.getUpdateInt();

        // Nếu người dùng đã nhập sẵn có mới, cập nhật thông tin tương ứng
        if (availabilityUpdate != -1) {
            doctor.setAvailability(availabilityUpdate);
        }

        // Thông báo cập nhật thành công
        System.err.println("Update successful.");
    }

    public static void deleteDoctor(ArrayList<Doctor> data) {
        System.out.println("---------- Delete Doctor ----------");
        System.out.print("Enter code Doctor to Delete: ");
        String code = Validate.getString("Invalid code Enter again:", Validate.CODE_VALID);
        Doctor doctor = getDoctorByCode(data, code);

        if (doctor == null) {
            System.err.println("Doctor not found.");
            return;
        }

        data.remove(doctor);
        System.err.println("Delete successful.");
    }
    public static void searchDoctor(ArrayList<Doctor> data) {
    System.out.println("---------- Search Doctor ----------");
    String nameSearch = Validate.getStringSearchDoctor();

    if (nameSearch.isEmpty()) {
        // Nếu người dùng không nhập gì, hiển thị tất cả dữ liệu
        displayAllDoctors(data);
    } else {
        // Ngược lại, thực hiện tìm kiếm và hiển thị kết quả
        ArrayList<Doctor> listFoundByName = listFoundByName(data, nameSearch);

        if (listFoundByName.isEmpty()) {
            System.err.println("List empty.");
        } else {
            System.out.println("----------------------------- Result -----------------------------");
            System.out.printf("%-15s%-15s%-20s%-15s\n", "Code", "Name", "Specialization", "Availability");

            for (Doctor doctor : listFoundByName) {
                System.out.printf("%-15s%-15s%-20s%-15d\n", doctor.getCode(), doctor.getName(),
                        doctor.getSpecialization(), doctor.getAvailability());
            }
        }
    }
}
// Thêm phương thức hiển thị tất cả bác sĩ
public static void displayAllDoctors(ArrayList<Doctor> data) {
    System.out.println("----------------------------- All Doctors -----------------------------");
    System.out.printf("%-15s%-15s%-20s%-15s\n", "Code", "Name", "Specialization", "Availability");

    for (Doctor doctor : data) {
        System.out.printf("%-15s%-15s%-20s%-15d\n", doctor.getCode(), doctor.getName(),
                doctor.getSpecialization(), doctor.getAvailability());
    }
}

    //  Tìm kiếm và trả về danh sách các bác sĩ chứa tên được nhập.
    public static ArrayList<Doctor> listFoundByName(ArrayList<Doctor> data, String stringToSeach  ) {
        ArrayList<Doctor> listFoundByName = new ArrayList<>();
        for (Doctor doctor : data) {
            //  Chuyển đổi tên bác sĩ và tên được nhập về chữ thường và kiểm tra xem tên có chứa từ khóa không.
            if (doctor.getName().toLowerCase().contains(stringToSeach.toLowerCase())||
                    doctor.getCode().toLowerCase().contains(stringToSeach.toLowerCase())||
                    doctor.getSpecialization().toLowerCase().contains(stringToSeach.toLowerCase())) {
                listFoundByName.add(doctor);
            }          
        }
        return listFoundByName;
    }

    // Kiểm tra xem mã code có tồn tại trong danh sách bác sĩ hay không.
    public static boolean checkCodeExist(ArrayList<Doctor> data, String code) {
        for (Doctor doctor : data) {
            // So sánh mã code (không phân biệt chữ hoa, chữ thường).
            if (code.equalsIgnoreCase(doctor.getCode())) {
                return true;
            }
        }
        return false;
    }

    //  Tìm bác sĩ theo mã code và trả về đối tượng Doctor tương ứng.
    public static Doctor getDoctorByCode(ArrayList<Doctor> data, String code) {
        for (Doctor doctor : data) {
            // So sánh mã code (không phân biệt chữ hoa, chữ thường).
            if (code.equalsIgnoreCase(doctor.getCode())) {
                return doctor;
            }
        }
        return null;
    }
}
