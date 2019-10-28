package by.epam.finance.dao;

import java.io.*;

public class DBReader implements Closeable {

    private static final String DATA_FILE_PATH = "src\\resources\\db.txt";

    BufferedReader bufferedReader = new BufferedReader(new FileReader(DATA_FILE_PATH));

    public DBReader() throws FileNotFoundException {
    }

    public String readOneLine() throws IOException{
        return bufferedReader.readLine();
    }

    @Override
    public void close() throws IOException {
        bufferedReader.close();
    }
}
