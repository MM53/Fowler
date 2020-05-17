import java.util.stream.Stream;

public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private PriceCode priceCode;

    public Movie(String title, int priceCodeIndex) {
        this.title = title;
        setPriceCode(priceCodeIndex);
    }

    public int getPriceCode() {
        return priceCode.ordinal();
    }

    public void setPriceCode(int priceCodeIndex) {
        priceCode = Stream.of(PriceCode.values())
                          .filter(value -> value.ordinal() == priceCodeIndex)
                          .findFirst()
                          .orElseThrow(() -> new IllegalArgumentException("No PriceCode fond with index: " + priceCodeIndex));
    }

    public String getTitle() {
        return title;
    }

    public double getCharge(int daysRented) {
        return priceCode.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return priceCode.getFrequentRenterPoints(daysRented);
    }
}