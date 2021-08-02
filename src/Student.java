import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private  String phoneNumber;
    private String major;
    private boolean level;//true = Đại học, false = Cao Đẳng

    public Student() {
    }

    public Student(String name, int age, String phoneNumber, String major, boolean level) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.major = major;
        this.level = level;
    }

    public Student(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Tên: '" + name + '\'' +
                ", SĐT: '" + phoneNumber + '\'' +
                ", Hệ: " + (level?"Đại học":"Cao Đẳng");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public boolean isLevel() {
        return level;
    }

    public void setLevel(boolean level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getPhoneNumber(), student.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getPhoneNumber(), getMajor(), isLevel());
    }
}
