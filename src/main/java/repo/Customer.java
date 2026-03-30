package repo;

public class Customer {
    private String id;
    private int creditScore;
    private double income; // <--- DEBE SER DOUBLE

    public Customer(String id, int creditScore, double income) {
        this.id = id;
        this.creditScore = creditScore;
        this.income = income;
    }

    // Agrega este Getter, lo necesitarás para la lógica del 30%
    public double getIncome() {
        return income;
    }
}