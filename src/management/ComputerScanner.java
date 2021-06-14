package management;

import model.Computer;
import model.Service;

import java.util.*;

public class ComputerScanner {
    Scanner sc = new Scanner(System.in);
    ServiceScanner serviceControl = new ServiceScanner();

    public boolean checkExist(int id, HashMap<Integer, Computer> hashMap) {
        Set<Integer> keys = hashMap.keySet();
        for (Integer key : keys) {
            if (hashMap.get(key).getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void displayAll(HashMap<Integer, Computer> hashMap) {
        Set<Integer> keys = hashMap.keySet();
        for (Integer key : keys) {
            System.out.println(hashMap.get(key).toString());
            ;
        }
    }

    public void delete(int id, HashMap<Integer, Computer> hashMap) {
        boolean result = checkExist(id, hashMap);
        int choice = 0;
        if (result == true) {
            System.out.println("Bạn có muốn tiếp tục xóa? (1.Xóa/2.Hủy)");
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
                hashMap.remove(id);
                System.out.println("Xóa thành công!");
            } else {
                System.out.println("Đã hủy thao tác!");
            }
        } else {
            System.out.println("ID không tồn tại!");
        }
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

    public Computer creat(HashMap<Integer, Computer> hashMap) {
        System.out.println("Nhập ID máy: ");
        int id = inputInt();
        System.out.println("Nhập tên máy :");
        String name;
        boolean result = true;
        do {
            name = sc.nextLine();
            result = checkExist(id, hashMap);
        } while (result == true);
        System.out.println("Phí sử dụng mỗi giờ :");
        int pricePerHour = inputInt();
        Computer computer = new Computer(id, name, pricePerHour);
        return computer;
    }

    public void editName(int id, HashMap<Integer, Computer> hashMap) {
        System.out.println("Nhập vào tên mới : ");
        String name = "";
        do {
            name = sc.nextLine();
        } while (hashMap.get(id).getName().equals(name));
        hashMap.get(id).setName(name);
    }

    public void editPricePerHour(int id, HashMap<Integer, Computer> hashMap) {
        System.out.println("Nhập giá tiền mới : ");
        int pricePerHour = inputInt();
        hashMap.get(id).setPricePerHour(pricePerHour);
    }

    public void edit(int id, HashMap<Integer, Computer> hashMap) {
        editName(id, hashMap);
        editPricePerHour(id, hashMap);
    }

    public void serviceUse(int id, HashMap<Integer, Computer> hashMap) {
        List<Service> services = hashMap.get(id).getList();
        for (Service service : services) {
            System.out.println(service.toString());
        }
    }

    public void turnOn(int id, HashMap<Integer, Computer> hashMap) {
        if (hashMap.get(id).isStatus() == true) {
            System.out.println("Máy đang hoạt động!");
        } else {
            hashMap.get(id).setStatus(true);
            hashMap.get(id).setStartTimeUse(System.currentTimeMillis());
            System.out.println("Bật máy thành công");
        }
    }

    public void turnOff(int id, HashMap<Integer, Computer> hashMap) {
        if (hashMap.get(id).isStatus() == true) {
            hashMap.get(id).setStatus(false);
            System.out.println("Đã tắt máy!");
        } else {
            System.out.println("Máy đang tắt!");
        }
    }


    public void addService(int idComputer, HashMap<Integer, Computer> hashMap, HashMap<Integer, Service> serviceHashMap) {
        serviceControl.display(serviceHashMap);
        System.out.println("Nhập ID dịch vụ :");
        int id = 0;
        boolean result = false;
        while (result == false) {
            id = inputInt();
            result = serviceControl.checkID(id, serviceHashMap);
            if (result == false) {
                System.out.println("Lỗi! Mời nhập lại :");
            }
        }
        System.out.println("Nhập số lượng : ");
        int amout = inputInt();
        Service service = new Service(id, serviceHashMap.get(id).getServiceName(), serviceHashMap.get(id).getServicePrices(), amout);
        serviceHashMap.get(id).setAmount(serviceHashMap.get(id).getAmount() - amout);
        hashMap.get(idComputer).getList().add(service);
        System.out.println("Thêm thành công!");
    }

    public int payments(int id, HashMap<Integer, Computer> hashMap) {
        if (hashMap.get(id).isStatus() == true) {
            List<Service> list = hashMap.get(id).getList();
            long money = hashMap.get(id).getPayments();
            hashMap.get(id).setEndTimeUse(System.currentTimeMillis());
            int priceBytime = (int) ((hashMap.get(id).getEndTimeUse() - hashMap.get(id).getStartTimeUse())) / 3600000 * hashMap.get(id).getPricePerHour();
            if (priceBytime % 1000 >= 500) {
                priceBytime += (1000 - priceBytime % 1000);
            } else {
                priceBytime -= (priceBytime % 1000);
            }
            money += priceBytime;
            hashMap.get(id).setPayments(0);
            hashMap.get(id).setStartTimeUse(0);
            hashMap.get(id).setEndTimeUse(0);
            hashMap.get(id).setStatus(false);
            hashMap.get(id).setList(new ArrayList<>());
            return (int) money;
        }else {
            return 0;
        }
    }

    public void displayON(HashMap<Integer, Computer> hashMap) {
        Set<Integer> keys = hashMap.keySet();
        for (int key : keys) {
            if (hashMap.get(key).isStatus() == true) {
                System.out.println(hashMap.get(key).toString());
            }
        }
    }

    public void displayOFF(HashMap<Integer, Computer> hashMap) {
        Set<Integer> keys = hashMap.keySet();
        for (int key : keys) {
            if (hashMap.get(key).isStatus() == false) {
                System.out.println(hashMap.get(key).toString());
            }
        }
    }
}
