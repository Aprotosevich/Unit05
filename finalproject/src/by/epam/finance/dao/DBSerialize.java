package by.epam.finance.dao;

import by.epam.finance.bean.User;

import java.io.*;

public class DBSerialize {

    private String filePath = "src\\resources\\";

    public DBSerialize(String fileName){
        this.filePath = filePath + fileName + ".dat";
    }

    public boolean save(Object obj) throws DaoException {

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(obj);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public User takeUserByLogin(String login) throws DaoException {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
            User user = (User)objectInputStream.readObject();
            return user;
        } catch (Exception e) {
            throw new DaoException();
        }
    }
}
