package by.epam.finance.service;

import by.epam.finance.bean.User;
import by.epam.finance.dao.DBSerialize;
import by.epam.finance.dao.DaoException;

public class LogInService {

    private static final LogInService instance = new LogInService();

    private LogInService(){}

    public static LogInService getInstance(){
        return instance;
    }

    public boolean logIn(String login, String password) {
        DBSerialize dbSerialize = new DBSerialize(login);
        User user;
        try {
            user = dbSerialize.takeUserByLogin(login);
            if(user != null && user.getPassword().equals(password)){
                user.setLogged(true);
                dbSerialize.save(user);
                return true;
            }
            else return false;
        } catch (DaoException e) {
            e.printStackTrace();
            return false;
        }
    }


}
