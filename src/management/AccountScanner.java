package management;

import model.AccountAdmin;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class AccountScanner {
    Scanner sc = new Scanner(System.in);

    public static final AccountScanner accountControl = new AccountScanner();

    public AccountScanner() {
    }

    public static AccountScanner getInstance() {
        return accountControl;
    }

    public String logIn(HashMap<String, AccountAdmin> hashMap) {
        boolean check = false;
        String userName = null;
        String password = null;
        while (check == false) {
            System.out.println("Đăng nhập\nNhập tài khoản :");
            userName = sc.nextLine();
            System.out.println("Nhập mật khẩu");
            password = sc.nextLine();
            check = checkLogin(userName, password, hashMap);
            if (check == false) {
                System.out.println("Sai tài khoản hoặc mật khẩu!");
            }
        }
        return userName;
    }

    public boolean checkLogin(String userName, String password, HashMap<String, AccountAdmin> hashMap) {
        Set<String> keys = hashMap.keySet();
        for (String key : keys) {
            if (userName.equalsIgnoreCase(hashMap.get(key).getUserName()) && password.equals(hashMap.get(key).getPassword())) {
                return true;
            }
        }
        return false;
    }

    public void display(HashMap<String, AccountAdmin> hashMap) {
        Set<String> keys = hashMap.keySet();
        for (String key : keys){
            System.out.println(hashMap.get(key).toString());
        }
    }

    public boolean checkExist(String st, HashMap<String, AccountAdmin> hashMap) {
        Set<String> keys = hashMap.keySet();
        for (String key : keys) {
            if (hashMap.get(key).getUserName().equalsIgnoreCase(st)) {
                return true;
            }
        }
        return false;
    }

    public void add(HashMap<String, AccountAdmin> hashMap) {
        System.out.println("Nhập tên tài khoản :");
        String userName = null;
        boolean result = true;
        do {
            userName = sc.nextLine();
            result = checkExist(userName, hashMap);
            if (result == true) {
                System.out.println("Tài khoản đã tồn tại!");
            }
        } while (result == true);
        System.out.println("Nhập mật khẩu : ");
        String password = sc.nextLine();
        hashMap.put(userName, new AccountAdmin(userName, password));
    }

    public void editPassword(String userName, HashMap<String, AccountAdmin> hashMap) {
        boolean result = checkExist(userName, hashMap);
        if (result == false) {
            System.out.println("Tài khoản không tồn tại!");
        } else {
            String oldPassword;
            String newPassword;
            boolean check = false;
            while (check == false) {
                oldPassword = sc.nextLine();
                check = oldPassword.equals(hashMap.get(userName).getPassword());
                if (check == false) {
                    System.out.println("Sai mật khẩu! Mời nhập lại");
                }
            }
            System.out.println("Nhâp mật khẩu mới ");
            newPassword = sc.nextLine();
            hashMap.get(userName).setPassword(newPassword);
            System.out.println("Đổi mật khẩu thành công !");
        }
    }
}
