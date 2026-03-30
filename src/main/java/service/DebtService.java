package service;

import repo.Customer;

public interface DebtService {
    boolean hasDebts(Customer customer);
}