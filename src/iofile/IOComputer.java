package iofile;

import model.Computer;

import java.io.*;
import java.util.HashMap;

public class IOComputer {
    public static final String PATH = "D:\\02_Module2\\Case_Study_Module2\\src\\filedata\\computer.dat";

    public void write(String path, HashMap<Integer, Computer> hashMap) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(hashMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<Integer, Computer> read(String path) {
        HashMap<Integer, Computer> hashMap;
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            hashMap = (HashMap<Integer, Computer>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new HashMap<Integer, Computer>();
    }
}
