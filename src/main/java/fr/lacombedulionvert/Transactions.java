package fr.lacombedulionvert;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;

class Transactions {

    private static final String DELIMITER = "\n";

    private Map<Transaction, Integer> transactions;

    Transactions() {
        transactions = new LinkedHashMap<>();
    }

    void add(Operation operation, int amount) {
        transactions.put(
                new Transaction(operation, amount),
                getCurrentBalance(operation, amount)
        );
    }

    private int getCurrentBalance(Operation operation, int amount) {
        return operation.calculateCurrentBalance(amount, getLatestBalance());
    }

    private int getLatestBalance() {
        return transactions.values()
                .stream()
                .reduce(0, (first, second) -> second);
    }

    @Override
    public String toString() {
        return transactions.entrySet()
                .stream()
                .map(e -> e.getKey().toString() + e.getValue())
                .collect(joining(DELIMITER));
    }
}
