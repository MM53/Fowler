import java.util.stream.Stream;

public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private PriceCode priceCode;

    public Movie(String newtitle, int newpriceCode) {
        title = newtitle;
        setPriceCode(newpriceCode);
    }

    public int getPriceCode() {
        return priceCode.ordinal();
    }

    public void setPriceCode(int arg) {
        priceCode = Stream.of(PriceCode.values())
                          .filter(value -> value.ordinal() == arg)
                          .findFirst()
                          .orElseThrow(() -> new IllegalArgumentException("No PriceCode fond with index: " + arg));
    }

    public String getTitle() {
        return title;
    }

    public double getCharge(int daysRented) {
        return priceCode.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        if ((priceCode == PriceCode.NEW_RELEASE) && daysRented > 1) {
            return 2;
        }
        return 1;
    }
}