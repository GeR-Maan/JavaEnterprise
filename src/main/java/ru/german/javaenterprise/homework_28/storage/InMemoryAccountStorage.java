package ru.german.javaenterprise.homework_28.storage;

import by.tms.lesson2842onl.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryAccountStorage {
    private static final List<Account> ACCOUNTS = new ArrayList<>();

    public void save(Account account) {
        ACCOUNTS.add(account);
    }

    public Optional<Account> findByUsername(String username) {
        for (Account account : ACCOUNTS) {
            if (account.getUsername().equals(username)) {
                return Optional.of(account);
            }
        }
        return Optional.empty();
    }
}
