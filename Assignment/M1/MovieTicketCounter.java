import java.util.Scanner;

abstract class Ticket {
    protected static final double CONVENIENCE_FEE = 20.0;
    protected int count;

    Ticket(int count) { this.count = count; }
    abstract double pricePerTicket();

    double totalAmount() {
        return count * (pricePerTicket() + CONVENIENCE_FEE);
    }
}
class RegularTicket extends Ticket {
    RegularTicket(int count) { super(count); }
    double pricePerTicket() { return 150.0; }
}
class PremiumTicket extends Ticket {
    PremiumTicket(int count) { super(count); }
    double pricePerTicket() { return 250.0; }
}
class ReclinerTicket extends Ticket {
    ReclinerTicket(int count) { super(count); }
    double pricePerTicket() { return 400.0; }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String seat = sc.next().toUpperCase();
            int count = sc.nextInt();
            Ticket ticket;
            switch (seat) {
                case "REGULAR": ticket = new RegularTicket(count); break;
                case "PREMIUM": ticket = new PremiumTicket(count); break;
                case "RECLINER": ticket = new ReclinerTicket(count); break;
                default: throw new IllegalArgumentException("Unknown seat type: " + seat);
            }
            double amount = ticket.totalAmount();
            System.out.printf("%s: %.2f%n", seat, amount);
            total += amount;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}