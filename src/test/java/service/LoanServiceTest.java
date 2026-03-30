package service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import repo.Customer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@MockitoSettings(strictness = Strictness.LENIENT)


@ExtendWith(MockitoExtension.class)
class LoanServiceTest {

    @Mock
    CreditScoreService creditScoreService;

    @Mock
    DebtService debtService;

    @Mock
    SimulationService simulationService;

    @InjectMocks
    LoanService loanService;


    @Test
    @DisplayName("Debería rechazar el préstamo si el score es menor a 600")
    void reject_whenScoreLessThan600() {
        Customer customer = new Customer("1", 500, 2500);
        when(creditScoreService.getScore(customer)).thenReturn(500);
        boolean result = loanService.registerLoan(customer, 1000, 12);
        assertFalse(result, "El préstamo debería ser rechazado por score bajo (< 600)");
    }

}