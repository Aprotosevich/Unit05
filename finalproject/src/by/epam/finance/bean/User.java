package by.epam.finance.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {

    private String login;
    private String password;
    private boolean isLogged;

    private String firstName;
    private String lastName;
    private List<Account> userAccounts = new ArrayList<>();

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Account> getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(List<Account> userAccounts) {
        this.userAccounts = userAccounts;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public void addAcount(Account account){
        userAccounts.add(account);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isLogged == user.isLogged &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(userAccounts, user.userAccounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, isLogged, firstName, lastName, userAccounts);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", isLogged=" + isLogged +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userAccounts=" + userAccounts +
                '}';
    }
}
