package service;

import repo.Customer;

public class LoanService {

    private CreditScoreService creditScoreService;
    private DebtService debtService;
    private SimulationService simulationService;

    public LoanService(CreditScoreService creditScoreService,
                       DebtService debtService,
                       SimulationService simulationService) {
        this.creditScoreService = creditScoreService;
        this.debtService = debtService;
        this.simulationService = simulationService;
    }



    public boolean registerLoan(Customer customer, double amount, int months) {

        if (creditScoreService.getScore(customer) < 600) return false;
        if (debtService.hasDebts(customer)) return false;
        if (months < 6 || months > 60) return false;
        double cuota = amount / months;
        if (cuota > (customer.getIncome() * 0.30)) return false;
        if (!simulationService.isSimulated(customer)) return false;

        return true;
    }
}
