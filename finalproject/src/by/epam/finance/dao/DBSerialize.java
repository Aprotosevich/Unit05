package by.epam.finance.dao;

import java.io.*;

public class DBSerialize {

    private String filePath = "src\\resources\\";

    public boolean save(Object obj, String fileName) {
        filePath = filePath + fileName + ".dat";

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(obj);
            return true;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
}
