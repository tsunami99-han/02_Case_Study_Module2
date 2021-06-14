package iofile;

import model.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Set;

public class IOService {
    public static final String PATH = "D:\\02_Module2\\Case_Study_Module2\\src\\filecsv\\serviceList.csv";

    public static void write(String path,HashMap<Integer, Service> hashMap)  {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String string = "Mã,Tên sản phẩm,Gía tiền,Số lượng \n";
            Set<Integer> keys = hashMap.keySet();
            for (Integer key : keys) {
                string += hashMap.get(key).getId() + "," + hashMap.get(key).getServiceName() + "," + hashMap.get(key).getServicePrices() + "," + hashMap.get(key).getAmount() + "\n";
            }
            bufferedWriter.write(string);
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static HashMap<Integer,Service> read(String path) throws IOException {
        HashMap<Integer,Service> hashMap=new HashMap<>();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        while ((line=bufferedReader.readLine())!=null){
            String[] values=line.split(",");
            Service service=new Service(Integer.parseInt(values[0]),values[1],Integer.parseInt(values[2]),Integer.parseInt(values[3]));
            hashMap.put(Integer.parseInt(values[0]),service);
        }
        bufferedReader.close();
        fileReader.close();
        return hashMap;
    }
}
