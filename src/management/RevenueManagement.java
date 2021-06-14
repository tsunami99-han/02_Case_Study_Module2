package management;

import iofile.IORevenue;
import model.Revenue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RevenueManagement {
    List<Revenue> revenues;

    public static final RevenueManagement revenueManagement = new RevenueManagement();

    public RevenueManagement() {
        this.revenues = IORevenue.readData(IORevenue.PATH_CSV);
    }

    public static RevenueManagement getInstance() {
        return revenueManagement;
    }

    public List<Revenue> getRevenues() {
        return revenues;
    }

    public void setRevenues(List<Revenue> revenues) {
        this.revenues = revenues;
    }

    public void display(List<Revenue> revenues) {
        for (Revenue revenue : revenues) {
            System.out.println(revenue.toString());
        }
    }

    public long revenue(List<Revenue> revenues) {
        long money = 0;
        for (Revenue revenue : revenues) {
            money += revenue.getAmountOfMoney();
        }
        return money;
    }

    public List<Revenue> findByName(String name) {
        List<Revenue> list=new ArrayList<>();
        for (Revenue revenue : revenues) {
            if (revenue.getUserAdmin().equals(name)) {
                list.add(revenue);
            }
        }
        return list;
    }

    public List<Revenue> revenueByMonth(int month,int year){
        List<Revenue> list=new ArrayList<>();
        for (Revenue revenue: revenues){
            if (revenue.getTime().getMonthValue()==month&&revenue.getTime().getYear()==year){
               list.add(revenue);
            }
        }
        return list;
    }

    public void add(Revenue revenue) {
        revenues.add(revenue);
    }
}
