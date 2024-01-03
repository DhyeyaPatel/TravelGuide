package main.entity;

public enum Subscription {
    STANDARD {
        @Override
        public boolean canSignUpForActivity(Passenger passenger, Activity activity) {
            return passenger.getBalance() >= activity.getCost();
        }

        @Override
        public void deductCostFromBalance(Passenger passenger, double cost) {
            passenger.setBalance(passenger.getBalance() - cost);
        }
    },
    GOLD {
        @Override
        public boolean canSignUpForActivity(Passenger passenger, Activity activity) {
            return passenger.getBalance() >= (activity.getCost() * 0.9);
        }

        @Override
        public void deductCostFromBalance(Passenger passenger, double cost) {
            passenger.setBalance(passenger.getBalance() - (cost * 0.9));
        }
    },
    PREMIUM {
        @Override
        public boolean canSignUpForActivity(Passenger passenger, Activity activity) {
            return true; // Premium passengers can sign up for any activity for free
        }

        @Override
        public void deductCostFromBalance(Passenger passenger, double cost) {
            // Premium passengers don't pay for activities
        }
    };

    public abstract boolean canSignUpForActivity(Passenger passenger, Activity activity);

    public abstract void deductCostFromBalance(Passenger passenger, double cost);
}