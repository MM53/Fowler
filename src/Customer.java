
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
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";
        result += rentals.stream()
                         .map(rental -> "\t" + rental.getMovie().getTitle() + "\t" + "\t" + rental.getDaysRented() + "\t" + rental.getCharge() + "\n")
                         .collect(Collectors.joining());

        //add footer lines
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    private int getFrequentRenterPoints() {
        return rentals.stream()
                      .mapToInt(Rental::getFrequentRenterPoints)
                      .sum();
    }

    private double getTotalCharge() {
        return rentals.stream()
                      .mapToDouble(Rental::getCharge)
                      .sum();
    }
}
    