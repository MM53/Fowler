public enum PriceCode {
    REGULAR {
        @Override
        double getCharge(int daysRented) {
            return (daysRented > 2) ? 2 + (daysRented - 2) * 1.5 : 2;
        }

        @Override
        int getFrequentRenterPoints(int daysRented) {
            return 1;
        }
    },
    NEW_RELEASE {
        @Override
        double getCharge(int daysRented) {
            return daysRented * 3;
        }

        @Override
        int getFrequentRenterPoints(int daysRented) {
            return (daysRented > 1) ? 2: 1;
        }
    },
    CHILDREN {
        @Override
        double getCharge(int daysRented) {
            return (daysRented > 3) ? 1.5 + (daysRented - 3) * 1.5 : 1.5;
        }

        @Override
        int getFrequentRenterPoints(int daysRented) {
            return 1;
        }
    };

    PriceCode() {

    }

    abstract double getCharge(int daysRented);

    abstract int getFrequentRenterPoints(int daysRented);
}
