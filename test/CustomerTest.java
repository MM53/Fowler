import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    private static final Movie regularMovie = new Movie("regular Movie", 0);
    private static final Movie newReleaseMovie = new Movie("new release Movie", 1);
    private static final Movie childrenMovie = new Movie("children Movie", 2);

    @Test
    void testCustomerNoMovie() {
        Customer c1 = new Customer("joe");

        String expected = "Rental Record for joe\n" +
                          "\tTitle\t\tDays\tAmount\n" +
                          "Amount owed is 0.0\n" +
                          "You earned 0 frequent renter points";
        assertEquals(expected, c1.statement());
    }

    @Test
    void testCustomerRegularMovieOneDay() {
        Rental rental  = new Rental(regularMovie, 1);
        Customer c1 = new Customer("joe");
        c1.addRental(rental);

        String expected = "Rental Record for joe\n" +
                          "\tTitle\t\tDays\tAmount\n" +
                          "\tregular Movie\t\t1\t2.0\n" +
                          "Amount owed is 2.0\n" +
                          "You earned 1 frequent renter points";
        assertEquals(expected, c1.statement());
    }

    @Test
    void testCustomerRegularMovieMoreDays() {
        Rental rental  = new Rental(regularMovie, 5);
        Customer c1 = new Customer("joe");
        c1.addRental(rental);

        String expected = "Rental Record for joe\n" +
                          "\tTitle\t\tDays\tAmount\n" +
                          "\tregular Movie\t\t5\t6.5\n" +
                          "Amount owed is 6.5\n" +
                          "You earned 1 frequent renter points";
        assertEquals(expected, c1.statement());
    }

    @Test
    void testCustomerNewReleaseMovieOneDay() {
        Rental rental  = new Rental(newReleaseMovie, 1);
        Customer c1 = new Customer("joe");
        c1.addRental(rental);

        String expected = "Rental Record for joe\n" +
                          "\tTitle\t\tDays\tAmount\n" +
                          "\tnew release Movie\t\t1\t3.0\n" +
                          "Amount owed is 3.0\n" +
                          "You earned 1 frequent renter points";
        assertEquals(expected, c1.statement());
    }

    @Test
    void testCustomerNewReleaseMovieMoreDays() {
        Rental rental  = new Rental(newReleaseMovie, 5);
        Customer c1 = new Customer("joe");
        c1.addRental(rental);

        String expected = "Rental Record for joe\n" +
                          "\tTitle\t\tDays\tAmount\n" +
                          "\tnew release Movie\t\t5\t15.0\n" +
                          "Amount owed is 15.0\n" +
                          "You earned 2 frequent renter points";
        assertEquals(expected, c1.statement());
    }

    @Test
    void testCustomerChildrenMovieOneDay() {
        Rental rental  = new Rental(childrenMovie, 1);
        Customer c1 = new Customer("joe");
        c1.addRental(rental);

        String expected = "Rental Record for joe\n" +
                          "\tTitle\t\tDays\tAmount\n" +
                          "\tchildren Movie\t\t1\t1.5\n" +
                          "Amount owed is 1.5\n" +
                          "You earned 1 frequent renter points";
        assertEquals(expected, c1.statement());
    }

    @Test
    void testCustomerChildrenMovieMoreDays() {
        Rental rental  = new Rental(childrenMovie, 5);
        Customer c1 = new Customer("joe");
        c1.addRental(rental);

        String expected = "Rental Record for joe\n" +
                          "\tTitle\t\tDays\tAmount\n" +
                          "\tchildren Movie\t\t5\t4.5\n" +
                          "Amount owed is 4.5\n" +
                          "You earned 1 frequent renter points";
        assertEquals(expected, c1.statement());
    }

    @Test
    void testCustomerAllMoviesOneDay() {
        Rental rental1  = new Rental(regularMovie, 1);
        Rental rental2 = new Rental(newReleaseMovie, 1);
        Rental rental3  = new Rental(childrenMovie, 1);

        Customer c1 = new Customer("joe");
        c1.addRental(rental1);
        c1.addRental(rental2);
        c1.addRental(rental3);

        String expected = "Rental Record for joe\n" +
                          "\tTitle\t\tDays\tAmount\n" +
                          "\tregular Movie\t\t1\t2.0\n" +
                          "\tnew release Movie\t\t1\t3.0\n" +
                          "\tchildren Movie\t\t1\t1.5\n" +
                          "Amount owed is 6.5\n" +
                          "You earned 3 frequent renter points";
        assertEquals(expected, c1.statement());
    }

    @Test
    void testCustomerAllMoviesMoreDays() {
        Rental rental1  = new Rental(regularMovie, 3);
        Rental rental2 = new Rental(newReleaseMovie, 5);
        Rental rental3  = new Rental(childrenMovie, 10);

        Customer c1 = new Customer("joe");
        c1.addRental(rental1);
        c1.addRental(rental2);
        c1.addRental(rental3);

        String expected = "Rental Record for joe\n" +
                          "\tTitle\t\tDays\tAmount\n" +
                          "\tregular Movie\t\t3\t3.5\n" +
                          "\tnew release Movie\t\t5\t15.0\n" +
                          "\tchildren Movie\t\t10\t12.0\n" +
                          "Amount owed is 30.5\n" +
                          "You earned 4 frequent renter points";
        assertEquals(expected, c1.statement());
    }
}
