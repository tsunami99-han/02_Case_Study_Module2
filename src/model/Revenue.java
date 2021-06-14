package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Revenue implements Serializable {
    private long amountOfMoney;
    private LocalDate time;
    private String userAdmin;

    public Revenue() {
    }

    public Revenue(long amountOfMoney, LocalDate time, String userAdmin) {
        this.amountOfMoney = amountOfMoney;
        this.time = time;
        this.userAdmin = userAdmin;
    }

    public long getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(long amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public String getUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(String userAdmin) {
        this.userAdmin = userAdmin;
    }

    @Override
    public String toString() {
        return "Số tiền " + amountOfMoney +
                " Ngày " + time +
                " Người quản lý " + userAdmin ;
    }
}
