class Ticket {
    private int ticketNumber;
    private String customerName;
    private int seatNumber;

    public Ticket(int ticketNumber, String customerName, int seatNumber) {
        this.ticketNumber = ticketNumber;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void printDetails() {
        System.out.println("Ticket Number : " + ticketNumber);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Seat Number : " + seatNumber);
        System.out.println();
    }
}

class BookingSystem {
    private Ticket[] tickets = new Ticket[10];
    private int bookingCount = 0;

    public void bookTicket(int ticketNumber, String customerName, int seatNumber) {
        if (bookingCount >= 10) {
            System.out.println("All seats are booked.");
            return;
        }

        for (int i = 0; i < bookingCount; i++) {
            if (tickets[i].getSeatNumber() == seatNumber) {
                System.out.println("Seat " + seatNumber + " is already booked.");
                return;
            }
        }

        tickets[bookingCount] = new Ticket(ticketNumber, customerName, seatNumber);
        bookingCount++;
        System.out.println("Ticket booked successfully for " + customerName + ".");
    }

    public void cancelTicket(int ticketNumber) {
        boolean found = false;
        for (int i=0; i<bookingCount; i++) {
            if (tickets[i].getTicketNumber() == ticketNumber) {
                for (int j=i; j<bookingCount-1; j++) {
                    tickets[j] = tickets[j+1];
                }
                tickets[bookingCount-1] = null;
                bookingCount--;
                System.out.println("Ticket number " + ticketNumber + " cancelled.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Ticket number " + ticketNumber + " not found.");
        }
    }

    public void displayBookings() {
        System.out.println("\n--- Current Bookings ---");
        if (bookingCount == 0) {
            System.out.println("No bookings available.");
        } else {
            for (int i=0; i<bookingCount; i++) {
                tickets[i].printDetails();
            }
        }
    }
}

public class Q_04 {
    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();

        system.bookTicket(1,"Alice",1);
        system.bookTicket(2,"Bob",2);
        system.bookTicket(3,"Carol",3);

        system.cancelTicket(2);

        system.bookTicket(4,"David",2); 

        system.displayBookings();
    }
}
