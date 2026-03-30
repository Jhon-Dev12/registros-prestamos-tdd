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
        if (creditScoreService.getScore(customer) < 600) {
            return false;
        }
        return true;
    }
}
