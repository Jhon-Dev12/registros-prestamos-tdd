package service;

import repo.Customer;

public interface CreditScoreService {
    int getScore(Customer customer);
}