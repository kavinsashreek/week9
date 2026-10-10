import java.util.Scanner;

interface BusUser {
    double transportFee();
}
abstract class Student {
    protected String name;
    Student(String name) { this.name = name; }
    abstract double tuitionFee();
    double hostelFee() { return 0.0; }
    double totalFee() { return tuitionFee() + hostelFee()
            + (this instanceof BusUser ? ((BusUser) this).transportFee() : 0.0); }
}
class DayScholar extends Student implements BusUser {
    DayScholar(String name) { super(name); }
    double tuitionFee() { return 40000.0; }
    public double transportFee() { return 12000.0; }
}
class Hosteller extends Student {
    Hosteller(String name) { super(name); }
    double tuitionFee() { return 40000.0; }
    double hostelFee() { return 60000.0; }
}
class ScholarshipStudent extends Student implements BusUser {
    ScholarshipStudent(String name) { super(name); }
    double tuitionFee() { return 20000.0; }
    public double transportFee() { return 12000.0; }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            Student student;
            switch (type) {
                case "DAY_SCHOLAR": student = new DayScholar(name); break;
                case "HOSTELLER": student = new Hosteller(name); break;
                case "SCHOLAR": student = new ScholarshipStudent(name); break;
                default: throw new IllegalArgumentException("Unknown student type: " + type);
            }
            double fee = student.totalFee();
            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }
        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}