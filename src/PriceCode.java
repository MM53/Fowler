public enum PriceCode {
    REGULAR {
        @Override
        double getCharge(int daysRented) {
            return (daysRented > 2) ? 2 + (daysRented - 2) * 1.5 : 2;
        }
    },
    NEW_RELEASE {
        @Override
        double getCharge(int daysRented) {
            return daysRented * 3;
        }
    },
    CHILDREN {
        @Override
        double getCharge(int daysRented) {
            return (daysRented > 3) ? 1.5 + (daysRented - 3) * 1.5 : 1.5;
        }
    };

    PriceCode() {

    }

    abstract double getCharge(int daysRented);
}
