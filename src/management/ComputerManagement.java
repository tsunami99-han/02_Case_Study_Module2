package management;

import iofile.IOComputer;
import model.AccountAdmin;
import model.Computer;

import java.util.HashMap;

public class ComputerManagement implements GeneralManagement<Computer> {
    HashMap<Integer, Computer> hashMap;
    HashMap<String, AccountAdmin> adminHashMap;
    public static final ComputerManagement managerCyber = new ComputerManagement();
    ComputerScanner computerScanner = new ComputerScanner();
    IOComputer ioComputer = new IOComputer();

    public ComputerScanner getComputerScanner() {
        return computerScanner;
    }

    public void setComputerScanner(ComputerScanner computerScanner) {
        this.computerScanner = computerScanner;
    }

    public HashMap<Integer, Computer> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<Integer, Computer> hashMap) {
        this.hashMap = hashMap;
    }

    public HashMap<String, AccountAdmin> getAdminHashMap() {
        return adminHashMap;
    }

    public void setAdminHashMap(HashMap<String, AccountAdmin> adminHashMap) {
        this.adminHashMap = adminHashMap;
    }

    public ComputerManagement() {
        this.hashMap =ioComputer.read(IOComputer.PATH);
        this.adminHashMap = new HashMap<>();
        adminHashMap.put("tsunami", new AccountAdmin("tsunami", "darkstar99"));
        adminHashMap.put("admin", new AccountAdmin("admin", "admin"));
    }

    public static ComputerManagement getInstance() {
        return managerCyber;
    }

    @Override
    public void display() {
        computerScanner.displayAll(hashMap);
    }

    @Override
    public Computer findById(int id) {
        if (computerScanner.checkExist(id, hashMap) == true) {
            return hashMap.get(id);
        }
        return null;
    }

    @Override
    public void add() {
        Computer computer = computerScanner.creat(hashMap);
        hashMap.put(computer.getId(), computer);
    }

    @Override
    public void edit(int id) {
        computerScanner.edit(id, hashMap);
    }

    @Override
    public void delete(int id) {
        computerScanner.delete(id, hashMap);
    }
}
