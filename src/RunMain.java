import java.util.*;
import java.util.stream.Collectors;

public class RunMain {
    public static List<Student> list;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        list = new ArrayList<>();
        list.add(new Student("Vũ Văn Doan", 2000, "0987328540", "CNTT", true));
        list.add(new Student("Nguyễn Anh Linh", 2000, "0987364541", "CNTT", true));
        list.add(new Student("Nguyễn Đức Điệp", 2000, "0988328542", "CNTT", true));
        list.add(new Student("Nguyễn Thị Hải Anh", 2000, "0994328543", "CNTT", true));
        list.add(new Student("Trần Văn Độ", 2001, "0994328843", "KHMT", false));
        list.add(new Student("Trần Văn Bắc", 2001, "0994328843", "KHMT", false));
        list.add(new Student("Nguyễn Ngọc Hồng", 2002, "0994328843", "KHMT", false));
        list.add(new Student("Nguyễn Đức Điệp", 1999, "0994368543", "KTPM", true));
        list.add(new Student("Vũ Đức Đạt", 1999, "0994368543", "KTPM", true));
        menu();
    }

    private static void menu() {
        int chose = 0;
        do {
            System.out.println("-------------------------------------------------");
            System.out.println("|1. Thêm, sửa, xóa sinh viên                    |");
            System.out.println("|2. Hiển thị danh sách sinh viên                |");
            System.out.println("|3. Sắp xếp danh sách sinh viên                 |");
            System.out.println("|4. Lọc sinh viên theo hệ                       |");
            System.out.println("|5. Tìm kiếm sinh viên                          |");
            System.out.println("|0. Thoát chương trình                          |");
            System.out.println("-------------------------------------------------\n");
            System.out.print("===> Nhập lựa chọn: ");
            try {
                chose = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                return;
            }
            switch (chose) {
                case 0:
                    return;
                case 1:
                    function1();//Thêm, sửa, xóa sinh viên
                    break;
                case 2:
                    displayList();
                    break;
                case 3:
                    function2();//Sắp xếp danh sách sinh viên
                    break;
                case 4:
                    function3();//Lọc danh sách theo hệ CĐ, ĐH
                    break;
                case 5:
                    function4();//Tìm kiếm sinh viên
                    break;
                default:
                    break;
            }
        } while (true);
    }

    private static void displayList() {
        System.out.println("--------- Danh sách sinh viên: ");
        int count = 1;
        for (Student s : list) {
            System.out.println(count + "." + s);
            count++;
        }
    }

    private static void function4() {//Tìm kiếm sinh viên
        System.out.print("--------Nhập từ khóa tìm kiếm: ");
        scan.nextLine();
        String keySearch = scan.nextLine().toLowerCase();
        List<Student> fillterList = new ArrayList<>();
        for (Student s : list){
            String level = (s.isLevel()?"Đại học":"Cao Đẳng");
            if(s.getName().toLowerCase().contains(keySearch) || (""+s.getAge()).toLowerCase().contains(keySearch)
                    || s.getPhoneNumber().contains(keySearch) || s.getMajor().toLowerCase().contains(keySearch)
                    || level.toLowerCase().contains(keySearch))
                fillterList.add(s);
        }
        System.out.println("------Danh sách sinh viên đã lọc theo từ khóa: ");
        int count = 1;
        for (Student s : fillterList) {
            System.out.println(count + "." + s);
            count++;
        }
    }

    private static void function3() {//Lọc danh sách theo hệ CĐ, ĐH
        List<Student> list1 =  list.stream().filter(e -> e.isLevel()).collect(Collectors.toList());
        List<Student> list2 =  list.stream().filter(e -> !e.isLevel()).collect(Collectors.toList());
        System.out.println("--------Danh sách sinh viên hệ Đại Học: ");
        int count = 1;
        for (Student s : list1) {
            System.out.println(count + "." + s);
            count++;
        }
        System.out.println("--------Danh sách sinh viên hệ Cao Đẳng: ");
        count = 1;
        for (Student s : list2) {
            System.out.println(count + "." + s);
            count++;
        }
    }

    private static void function2() {//Sắp xếp danh sách sinh viên
        int chose = 0;
        do {
            System.out.println("\t---------------------------------------");
            System.out.println("\t|3.1 Sắp xếp theo tên                 |");
            System.out.println("\t|3.2 Sắp xếp theo năm sinh            |");
            System.out.println("\t|3.3 Sắp xếp theo SĐT                 |");
            System.out.println("\t|0. Quay lại menu chính               |");
            System.out.println("\t---------------------------------------\n");
            System.out.print("\t===> Nhập lựa chọn: ");
            try {
                chose = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                return;
            }
            switch (chose) {
                case 0:
                    return;
                case 1:
                    sortByName();
                    break;
                case 2:
                    sortByAge();
                    break;
                case 3:
                    sortByPhoneNumber();
                    break;
                default:
                    break;
            }
        } while (true);
    }

    private static void sortByPhoneNumber() {
        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getPhoneNumber().compareTo(o2.getPhoneNumber());
            }
        });
        System.out.println("------------Sắp xếp danh sách theo SĐT: ");
        displayList();
    }

    private static void sortByAge() {
        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println("------------Sắp xếp danh sách theo năm sinh: ");
        displayList();
    }

    private static void sortByName() {
        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int index1 = 0, index2 = 0;
                index1 = o1.getName().lastIndexOf(" " );
                index2 = o2.getName().lastIndexOf(" " );
                return o1.getName().substring(index1).compareTo(o2.getName().substring(index2));
            }
        });
        System.out.println("------------Sắp xếp danh sách theo tên: ");
        displayList();
    }

    private static void function1() {//Thêm sửa xóa sinh viên
        int chose = 0;
        do {
            System.out.println("\t---------------------------------------");
            System.out.println("\t|1.1 Thêm sinh viên                   |");
            System.out.println("\t|1.2 Sửa sinh viên                    |");
            System.out.println("\t|1.3 Xóa sinh viên                    |");
            System.out.println("\t|0. Quay lại menu chính               |");
            System.out.println("\t---------------------------------------\n");
            System.out.print("\t===> Nhập lựa chọn: ");
            try {
                chose = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                return;
            }
            switch (chose) {
                case 0:
                    return;
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    removeStudent();
                    break;
                default:
                    break;
            }
        } while (true);
    }

    private static void removeStudent() {//Xóa sinh viên
        System.out.println("\t-----Nhập số điện thoại sinh viên cần xóa: ");
        scan.nextLine();
        String phone = scan.nextLine();
        if (!isExistStudent(new Student(phone))) {
            System.out.println("Không có sinh viên nào có số điện thoại đã nhập!");
            return;
        }
        list.remove(list.indexOf(new Student(phone)));
        System.out.println("\tXóa thành công");
    }

    private static void updateStudent() {//Sửa thông tin sinh viên
        String name = "";
        int age = 0;
        String phoneNumber = "";
        String major = "";
        boolean level = true;//true = Đại học, false = Cao Đẳng
        System.out.println("\t-----Nhập số điện thoại sinh viên cần sửa thông tin: ");
        scan.nextLine();
        String phone = scan.nextLine();
        if (!isExistStudent(new Student(phone))) {
            System.out.println("Không có sinh viên nào có số điện thoại đã nhập!");
            return;
        }
        int index = list.indexOf(new Student(phone));
        System.out.println("\t---Nhập thông tin mới: ");
        System.out.print("\tHọ tên: ");
        name = scan.nextLine();
        System.out.print("\tTuổi: ");
        age = scan.nextInt();
        scan.nextLine();//xóa bộ đệm
//        boolean check = true;
//        do {
//            System.out.print("\tSố điện thoại(không được trùng): ");
//            phoneNumber = scan.nextLine();
//            check = isExistStudent(new Student(phoneNumber));
//            if (check) {
//                System.out.println("Nhập lại, số điện thoại của sinh viên này đã tồn tại!");
//            }
//        } while (check);
        System.out.print("\tNgành: ");
        major = scan.nextLine();
        System.out.print("\tHệ(Đại học - 1, Cao Đẳng - 0 : ");
        int temp = scan.nextInt();
        level = (temp == 1) ? true : false;
        list.set(index, new Student(name, age, phone, major, level));
        System.out.println("\tSửa thành công");
    }

    private static void addStudent() {//Thêm sinh viên
        String name = "";
        int age = 0;
        String phoneNumber = "";
        String major = "";
        boolean level = true;//true = Đại học, false = Cao Đẳng
        System.out.println("\t-----Nhập thông tin sinh viên để thêm mới: ");
        System.out.print("\tHọ tên: ");
        scan.nextLine();
        name = scan.nextLine();
        System.out.print("\tTuổi: ");
        age = scan.nextInt();
        scan.nextLine();//xóa bộ đệm

        boolean check = true;
        do {
            System.out.print("\tSố điện thoại(không được trùng): ");
            phoneNumber = scan.nextLine();
            check = isExistStudent(new Student(phoneNumber));
            if (check) {
                System.out.println("Nhập lại, số điện thoại của sinh viên này đã tồn tại!");
            }
        } while (check);
        System.out.print("\tNgành: ");
        major = scan.nextLine();
        System.out.print("\tHệ(Đại học - 1, Cao Đẳng - 0 : ");
        int temp = scan.nextInt();
        level = (temp == 1) ? true : false;
        list.add(new Student(name, age, phoneNumber, major, level));
        System.out.println("\tThêm thành công");
    }

    //True: Exist, False: not Exist
    private static boolean isExistStudent(Student s) {
        for (Student item : list) {
            if (item.equals(s)) {
                return true;
            }
        }
        return false;
    }
}