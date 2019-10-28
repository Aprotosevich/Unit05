package by.epam.finance.service;

import by.epam.finance.bean.User;
import by.epam.finance.dao.DBReader;
import by.epam.finance.dao.UserDao;
import by.epam.finance.dao.impl.UserDaoImpl;

import java.io.FileNotFoundException;

import static by.epam.finance.controller.Controller.PARAM_DELIMETER;

public class LogInService {

    private static final LogInService instance = new LogInService();

    private LogInService(){}

    public static LogInService getInstance(){
        return instance;
    }

    public boolean logIn(String login, String password) {
        try {
            DBReader dbReader = new DBReader();
            String input = "";
            while ((input = dbReader.readOneLine()) != null) {
                String[] inputArray = input.split(PARAM_DELIMETER + "");
                if(inputArray[0].equals(login)) {
                    if(inputArray[1].equals(password)){
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
