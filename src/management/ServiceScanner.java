package management;

import model.Service;

import java.util.*;

public class ServiceScanner {
    Scanner sc=new Scanner(System.in);
    public boolean checkID(int id, HashMap<Integer, Service> serviceHashMap) {
        Set<Integer> keys = serviceHashMap.keySet();
        for (Integer key : keys) {
            if (key == id) {
                return true;
            }
        }
        return false;
    }

    public void display( HashMap<Integer, Service> serviceHashMap) {
        Set<Integer> keys = serviceHashMap.keySet();
        for (Integer key : keys) {
            System.out.println(serviceHashMap.get(key).toString());
        }
    }

    public void delete(int id,HashMap<Integer, Service> serviceHashMap) {
        boolean result = checkID(id,serviceHashMap);
        int choice = 0;
        if (result == true) {
            System.out.println("Bạn có muốn tiếp tục xóa? (1.Yes/2.No)");
            while (choice != 1 && choice != 2) {
                try {
                    choice = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Lỗi kiểu nhập vào! Hãy nhập lại ");
                } finally {
                    sc.nextLine();
                }
            }
            if (choice == 1) {
                serviceHashMap.remove(id);

                System.out.println("Hoàn tất xóa!");
            } else {
                System.out.println("Đã hủy việc xóa!");
            }
        }else {
            System.out.println("ID không tồn tại!");
        }
    }

    public Service edit(int id,HashMap<Integer, Service> serviceHashMap) {
        editName(id,serviceHashMap);
        editPrice(id,serviceHashMap);
        editAmount(id,serviceHashMap);
        return serviceHashMap.get(id);
    }

    public Service creat(HashMap<Integer, Service> serviceHashMap) {
        System.out.println("Nhập mã dịch vụ : ");
        int id = -1;
        boolean result = true;
        while (result==true) {
            id = inputInt();
            result = checkID(id,serviceHashMap);
        }
        System.out.println("Tên dịch vụ :");
        String serviceName = sc.nextLine();
        System.out.println("Gía dịch vụ :");
        int servicePrice = inputInt();
        System.out.println("Số lượng");
        int amount = inputInt();
        Service service = new Service(id, serviceName, servicePrice, amount);
        return service;
    }

    public int inputInt() {
        int num = -1;
        while (num == -1)
            try {
                num = sc.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Lỗi kiểu nhập vào! Hãy nhập lại ");
            } finally {
                sc.nextLine();
            }
        return num;
    }

    public void editName(int id,HashMap<Integer, Service> serviceHashMap) {
        System.out.println("Nhập tên mới ");
        String newName = sc.nextLine();
        serviceHashMap.get(id).setServiceName(newName);
    }

    public void editPrice(int id,HashMap<Integer, Service> serviceHashMap) {
        System.out.println("Nhập giá mới :");
        int price = inputInt();
        serviceHashMap.get(id).setAmount(price);
    }

    public void editAmount(int id,HashMap<Integer, Service> serviceHashMap) {
        System.out.println("Nhập số lượng mới :");
        int amount = inputInt();
    }
}
