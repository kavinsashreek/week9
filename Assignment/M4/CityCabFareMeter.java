import java.util.Scanner;

abstract class Cab {
    protected static final double MINIMUM_FARE = 100.0;
    protected double km;
    Cab(double km) { this.km = km; }
    abstract double ratePerKm();
    double fare(boolean night) {
        double amount = Math.max(MINIMUM_FARE, km * ratePerKm());
        return night ? amount * 1.20 : amount;
    }
}
interface NightService {
    double nightFare(double baseFare);
}
class MiniCab extends Cab {
    MiniCab(double km) { super(km); }
    double ratePerKm() { return 10.0; }
}
class SedanCab extends Cab implements NightService {
    SedanCab(double km) { super(km); }
    double ratePerKm() { return 14.0; }
    public double nightFare(double baseFare) { return baseFare * 1.20; }
}
class SUVCab extends Cab implements NightService {
    SUVCab(double km) { super(km); }
    double ratePerKm() { return 18.0; }
    public double nightFare(double baseFare) { return baseFare * 1.20; }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase();
            boolean night = time.equals("NIGHT");
            Cab cab;
            switch (type) {
                case "MINI": cab = new MiniCab(km); break;
                case "SEDAN": cab = new SedanCab(km); break;
                case "SUV": cab = new SUVCab(km); break;
                default: throw new IllegalArgumentException("Unknown cab type: " + type);
            }
            if (night && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }
            double fare = cab.fare(false);
            if (night) fare = ((NightService) cab).nightFare(fare);
            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}