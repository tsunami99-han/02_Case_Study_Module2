package iofile;

import model.Revenue;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IORevenue {
    public static final String PATH = "D:\\02_Module2\\Case_Study_Module2\\src\\filecsv\\revenue.csv";

    public void writeCSV(String path, List<Revenue> revenues) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "Số tiền,Thời gian,Người quản lý\n";
        for (Revenue revenue : revenues) {
            str += revenue.getAmountOfMoney() + "," + revenue.getTime() + "," + revenue.getUserAdmin() + "\n";
        }
        bufferedWriter.write(str);
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();
    }

    public void writeData(String path, List<Revenue> revenues)  {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream((OutputStream) revenues);
            objectOutputStream.writeObject(revenues);
            objectOutputStream.close();
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public List<Revenue> readData(String path){
        List<Revenue> list;
        try {
            FileInputStream fileInputStream=new FileInputStream(path);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            list= (List<Revenue>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<Revenue>();
    }
}
