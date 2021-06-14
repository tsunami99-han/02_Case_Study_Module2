package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Computer implements Serializable {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;
    private long startTimeUse = 0;
    private long endTimeUse = 0;
    private int pricePerHour = 7000;
    private boolean status = false;
    private List<Service> list =new ArrayList<>();
    private LocalDate systemTime;
    private long payments = 0;

    public Computer() {
    }

    public Computer(int id,String name, int pricePerHour) {
        this.id=id;
        this.name = name;
        this.pricePerHour = pricePerHour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStartTimeUse() {
        return startTimeUse;
    }

    public void setStartTimeUse(long startTimeUse) {
        this.startTimeUse = startTimeUse;
    }

    public long getEndTimeUse() {
        return endTimeUse;
    }

    public void setEndTimeUse(long endTimeUse) {
        this.endTimeUse = endTimeUse;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Service> getList() {
        return list;
    }

    public void setList(List<Service> list) {
        this.list = list;
    }

    public LocalDate getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(LocalDate systemTime) {
        this.systemTime = systemTime;
    }

    public long getPayments() {
        for (Service service:list){
            payments+=service.getServicePrices()*service.getAmount();
        }
        return payments;
    }

    public void setPayments(long payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        if (this.status == false) {
            return "Mã " +this.id + "   Trạng thái máy"+this.name + " đang tắt " + this.pricePerHour + "/1h.";
        } else {
            long timeNow = System.currentTimeMillis();
            long hour = (timeNow - this.startTimeUse) / 3600000;
            long munite=(timeNow - this.startTimeUse)%3600000/60000;
            return "Mã " +this.id + "   Trạng thái máy "+ this.name + " đang sử dụng, Thời gian sử dụng : "+hour+"h "+munite + "m  " +"Tiền dịch vụ :"+ this.pricePerHour + "/1h." ;
        }
    }
}
