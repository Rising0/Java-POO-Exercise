package entities;

public final class Individual extends TaxPayer {

    private double healthExpending;

    public Individual(String name, double annualIncome, double healthExpending) {
        super(name, annualIncome);
        this.healthExpending = healthExpending;
    }

    public double getHealthExpending() {
        return healthExpending;
    }

    public void setHealthExpending(double healthExpending) {
        this.healthExpending = healthExpending;
    }

    @Override
    public double tax() {

        if (getAnnualIncome() < 20000.00 && healthExpending > 0) {
            return (getAnnualIncome() * 0.15) - (healthExpending * 0.5);
        }

        else if (getAnnualIncome() < 20000.00 && healthExpending <= 0) {
            return getAnnualIncome() * 0.15;
        }

        else if (getAnnualIncome() > 20000.00 && healthExpending > 0) {
            return (getAnnualIncome() * 0.25) - (healthExpending * 0.5);
        }

        else {
            return getAnnualIncome() * 0.25;
        }
    }
}
