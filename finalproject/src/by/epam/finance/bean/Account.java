package by.epam.finance.bean;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable {

    private String name;
    private long amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Account(){};

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return amount == account.amount &&
                Objects.equals(name, account.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount);
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
