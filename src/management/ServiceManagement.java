package management;

import iofile.IOService;
import model.Service;

import java.io.IOException;
import java.util.*;

import static iofile.IOService.PATH;

public class ServiceManagement implements GeneralManagement<Service> {
    HashMap<Integer, Service> hashMapService;
    public static final ServiceManagement serviceManagement = new ServiceManagement();
    ServiceScanner scannerService = new ServiceScanner();

    public ServiceManagement() {
        try {
            this.hashMapService = IOService.read(PATH);
        } catch (IOException e) {
            this.hashMapService=new HashMap<Integer, Service>();
        }
    }

    public static ServiceManagement getInstance() {
        return serviceManagement;
    }

    public HashMap<Integer, Service> getHashMapService() {
        return hashMapService;
    }

    public void setHashMapService(HashMap<Integer, Service> hashMapService) {
        this.hashMapService = hashMapService;
    }

    @Override
    public void display() {
        scannerService.display(hashMapService);
    }

    @Override
    public Service findById(int id) {
        Set<Integer> keys = hashMapService.keySet();
        for (Integer key : keys) {
            if (hashMapService.get(key).getId() == id) {
                return hashMapService.get(id);
            }
        }
        return null;
    }

    @Override
    public void add() {
        Service service = scannerService.creat(hashMapService);
        hashMapService.put(service.getId(), service);
    }

    @Override
    public void edit(int id) {
        scannerService.edit(id, hashMapService);
    }

    @Override
    public void delete(int id) {
        scannerService.delete(id, hashMapService);
    }
}
