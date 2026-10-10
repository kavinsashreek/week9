import java.util.Scanner;

abstract class Parcel {
    protected double weight;
    Parcel(double weight) { this.weight = weight; }
    abstract double shippingCharge();
    double insurance(double declaredValue) { return 0.0; }
}
interface Insurable {
    double insurance(double declaredValue);
}
class StandardParcel extends Parcel {
    StandardParcel(double weight) { super(weight); }
    double shippingCharge() { return 40 + 10 * weight; }
}
class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weight) { super(weight); }
    double shippingCharge() { return 80 + 15 * weight; }
    public double insurance(double value) { return value * 0.02; }
}
class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weight) { super(weight); }
    double shippingCharge() { return 40 + 10 * weight + 50; }
    public double insurance(double value) { return value * 0.02; }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            Parcel parcel;
            switch (type) {
                case "STANDARD": parcel = new StandardParcel(weight); break;
                case "EXPRESS": parcel = new ExpressParcel(weight); break;
                case "FRAGILE": parcel = new FragileParcel(weight); break;
                default: throw new IllegalArgumentException("Unknown parcel type: " + type);
            }
            double charge = parcel.shippingCharge();
            double insurance = parcel instanceof Insurable
                    ? ((Insurable) parcel).insurance(value) : 0.0;
            double total = charge + insurance;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    type, charge, insurance, total);
            grandTotal += total;
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}