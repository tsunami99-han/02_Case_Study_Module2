import iofile.IOComputer;
import iofile.IORevenue;
import iofile.IOService;
import management.*;
import model.AccountAdmin;
import model.Computer;
import model.Revenue;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        System.out.println("Chương trình quản lý!");
        System.out.println("1.Danh sách máy");
        System.out.println("2.Quản lý phòng máy");
        System.out.println("3.Dịch vụ phòng máy");
        System.out.println("4.Doanh thu");
        System.out.println("5.Tài khoản nhân viên");
        System.out.println("6.Quản lý dịch vụ");
        System.out.println("0.Thoát");
    }

    public static void computerManager() {
        System.out.println("Quản lý phòng máy");
        System.out.println("1.Thêm máy");
        System.out.println("2.Sửa");
        System.out.println("3.Xóa");
        System.out.println("0.Quay lại");
    }

    public static void service() {
        System.out.println("Tác vụ");
        System.out.println("1.Mở máy");
        System.out.println("2.Thêm dịch vụ sử dụng");
        System.out.println("3.Tính tiền và tắt máy");
        System.out.println("0.Quay lại!");
    }

    public static void serviceManager() {
        System.out.println("Quản lý dịch vụ :");
        System.out.println("1.Danh sách");
        System.out.println("2.Thêm mới");
        System.out.println("3.Sửa");
        System.out.println("4.Xóa");
        System.out.println("0.Quay lại");
        System.out.println("Nhập lựa chọn");
    }

    public static void userAdmin() {
        System.out.println("Quản lý tài khoản");
        System.out.println("1.Danh sách");
        System.out.println("2.Thêm mới");
        System.out.println("3.Đổi mât khẩu");
        System.out.println("4.Xóa tài khoản.");
        System.out.println("0.Quay lại");
    }

    public static void revenue() {
        System.out.println("Quản lý doanh thu");
        System.out.println("1.Tổng doanh thu");
        System.out.println("2.Doanh thu theo tháng");
        System.out.println("3.Doanh thu cá nhân.");
        System.out.println("4.Quay lại");
    }

    public static void display() {
        System.out.println("Hiển thị:");
        System.out.println("1.Máy online");
        System.out.println("2.Máy offline");
        System.out.println("3.Tất cả các máy");
        System.out.println("0.Quay lại");
    }

    public static int inputNum() {
        int num = -1;
        while (num == -1) {
            try {
                num = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Sai kiểu dữ liệu! Nhập lại :");
            } finally {
                scanner.nextLine();
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountScanner accountScanner = AccountScanner.getInstance();
        ComputerManagement computerManagement = ComputerManagement.getInstance();
        RevenueManagement revenueManagement = RevenueManagement.getInstance();
        ServiceManagement serviceManagement = ServiceManagement.getInstance();
        String userAdmin = accountScanner.logIn(computerManagement.getAdminHashMap());
        ServiceScanner serviceScanner = new ServiceScanner();
        HashMap<Integer, Computer> computerHashMap = computerManagement.getHashMap();
        HashMap<String, AccountAdmin> adminHashMap = computerManagement.getAdminHashMap();
        int choice;
        int option;
        boolean checkExist1 = false;
        while (true) {
            menu();
            System.out.println("Nhập lựa chọn:");
            choice = inputNum();
            switch (choice) {
                case 1:
                    boolean check = true;
                    while (check) {
                        display();
                        choice = inputNum();
                        switch (choice) {
                            case 1:
                                computerManagement.getComputerScanner().displayON(computerHashMap);
                                break;
                            case 2:
                                computerManagement.getComputerScanner().displayOFF(computerHashMap);
                                break;
                            case 3:
                                computerManagement.display();
                                break;
                            case 0:
                                check = false;
                                break;
                            default:
                                System.out.println("Không có lựa chọn!");
                        }
                    }
                    break;
                case 2:
                    boolean check1 = true;
                    while (check1) {
                        computerManager();
                        System.out.println("Nhập lựa chọn :");
                        choice = inputNum();
                        switch (choice) {
                            case 1:
                                computerManagement.add();
                                break;
                            case 2:
                                int id = 0;
                                boolean checkExist = false;
                                while (checkExist == false) {
                                    System.out.println("Nhập ID máy :");
                                    id = inputNum();
                                    checkExist = computerManagement.getComputerScanner().checkExist(id, computerHashMap);
                                    if (checkExist == false) {
                                        System.out.println("ID không tồn tại!Nhập lại");
                                    }
                                }
                                computerManagement.edit(id);
                                break;
                            case 3:
                                boolean checkExist2 = false;
                                int idDelete = 0;
                                while (checkExist2 == false) {
                                    System.out.println("Nhập ID máy :");
                                    idDelete = inputNum();
                                    checkExist = computerManagement.getComputerScanner().checkExist(idDelete, computerHashMap);
                                }
                                computerManagement.delete(idDelete);
                                break;
                            case 0:
                                check1 = false;
                                break;
                            default:
                                System.out.println("Không có lựa chọn");
                        }
                    }
                    break;
                case 3:
                    boolean checkExist = false;
                    boolean check2 = true;
                    computerManagement.display();
                    int id = 0;
                    while (checkExist == false) {
                        System.out.println("Nhập ID máy :");
                        id = inputNum();
                        checkExist = computerManagement.getComputerScanner().checkExist(id, computerHashMap);
                        if (checkExist == false) {
                            System.out.println("ID không tồn tại!Nhập lại");
                        }
                    }
                    while (check2) {
                        service();
                        System.out.println("Nhập lựa chon :");
                        choice = inputNum();
                        switch (choice) {
                            case 1:
                                computerManagement.getComputerScanner().turnOn(id, computerHashMap);
                                break;
                            case 2:
                                computerManagement.getComputerScanner().addService(id, computerHashMap, serviceManagement.getHashMapService());
                                break;
                            case 3:
                                int money = computerManagement.getComputerScanner().payments(id, computerHashMap);
                                if (money == 0) {
                                    System.out.println("Máy đang tắt");
                                } else {
                                    Revenue revenue = new Revenue(money, LocalDate.now(), userAdmin);
                                    System.out.println(revenue.toString());
                                    revenueManagement.add(revenue);
                                }
                                break;
                            case 0:
                                check2 = false;
                                break;
                            default:
                                System.out.println("Không có lựa chọn!");
                        }
                    }

                    break;
                case 4:
                    boolean check3 = true;
                    while (check3) {
                        revenue();
                        System.out.println("Nhập lựa chọn");
                        choice = inputNum();
                        switch (choice) {
                            case 1:
                                revenueManagement.display(revenueManagement.getRevenues());
                                System.out.println(revenueManagement.revenue(revenueManagement.getRevenues()));
                                break;
                            case 2:
                                System.out.println("Doanh thu theo tháng");
                                int month = -1;
                                int year = 0;
                                boolean check4 = true;
                                while (check4) {
                                    System.out.println("Nhập vào tháng");
                                    month = inputNum();
                                    if (month < 0 && month > 12) {
                                        System.err.println("Tháng nhập vào không phù hợp!Mời nhập lại!");
                                    } else {
                                        check4 = false;
                                    }
                                }
                                System.out.println("Nhập vào năm");
                                year = inputNum();
                                List<Revenue> list = revenueManagement.revenueByMonth(month, year);
                                revenueManagement.display(list);
                                System.out.println("Tổng doanh thu tháng " + month + " năm " + year + " là " + revenueManagement.revenue(list));
                                break;
                            case 3:
                                System.out.println("Nhập vào tên tài khoản quản lý : ");
                                String name = sc.nextLine();
                                List<Revenue> list1 = revenueManagement.findByName(name);
                                if (list1 == null) {
                                    System.out.println("Không có thông tin!");
                                } else {
                                    revenueManagement.display(list1);
                                    System.out.println("Tổng doanh thu của " + name + " là " + revenueManagement.revenue(list1));
                                }
                                break;
                            case 0:
                                check3 = false;
                                break;
                            default:
                                System.out.println("Không có lựa chọn!");
                        }
                    }
                    break;
                case 5:
                    boolean check5 = true;
                    while (check5) {
                        userAdmin();
                        choice = inputNum();
                        switch (choice) {
                            case 1:
                                accountScanner.display(adminHashMap);
                                break;
                            case 2:
                                accountScanner.add(adminHashMap);
                                break;
                            case 3:
                                System.out.println("Nhập tên tài khoản :");
                                String userName = sc.nextLine();
                                boolean rusult = accountScanner.checkExist(userName, adminHashMap);
                                if (rusult == false) {
                                    System.out.println("Tài khoản không tồn tại!");
                                } else {
                                    accountScanner.editPassword(userName, adminHashMap);
                                }
                                break;
                            case 0:
                                check5 = false;
                                break;
                            default:
                                System.out.println("Không có lựa chọn!");
                        }
                    }
                    break;
                case 6:
                    boolean check6 = true;
                    while (check6) {
                        serviceManager();
                        choice = inputNum();
                        int idService = 0;
                        switch (choice) {
                            case 1:
                                serviceManagement.display();
                                break;
                            case 2:
                                serviceManagement.add();
                                break;
                            case 3:
                                boolean checkExist3 = false;
                                while (checkExist3 == false) {
                                    System.out.println("Nhập ID :");
                                    idService = inputNum();
                                    checkExist3 = serviceScanner.checkID(idService, serviceManagement.getHashMapService());
                                    if (checkExist3 == false) {
                                        System.err.println("ID không tồn tại, nhập lại");
                                    }
                                }
                                serviceManagement.edit(idService);
                                break;
                            case 4:
                                idService=inputNum();
                                serviceManagement.delete(idService);
                                break;
                            case 0:
                                check6=false;
                                break;
                            default:
                                System.out.println("Không có lựa chọn!");
                        }
                    }
                    break;
                case 0:
                    IOComputer.write(IOComputer.PATH, computerHashMap);
                    IORevenue.writeData(IORevenue.PATH_DAT, revenueManagement.getRevenues());
                    IOService.write(IOService.PATH, serviceManagement.getHashMapService());
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không có lựa chọn!");
            }
        }

    }
}

