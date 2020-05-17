
import java.lang.*;
import java.util.*;
import java.util.stream.Collectors;

class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String newname) {
        name = newname;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;

        int frequentRenterPoints = rentals.stream()
                                          .mapToInt(Rental::getFrequentRenterPoints)
                                          .sum();
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";
        result += rentals.stream()
                         .map(rental -> "\t" + rental.getMovie().getTitle() + "\t" + "\t" + rental.getDaysRented() + "\t" + rental.getCharge() + "\n")
                         .collect(Collectors.joining());

        for (Rental each : rentals) {

            totalAmount += each.getCharge();
        }
        //add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }
}
    