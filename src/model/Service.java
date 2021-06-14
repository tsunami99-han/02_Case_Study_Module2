package model;

import java.io.Serializable;

public class Service implements Serializable {
    private int id;
    private String serviceName;
    private int servicePrices;
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Service() {
    }

    public Service(int id, String serviceName, int servicePrices, int amount) {
        this.id = id;
        this.serviceName = serviceName;
        this.servicePrices = servicePrices;
        this.amount=amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServicePrices() {
        return servicePrices;
    }

    public void setServicePrices(int servicePrices) {
        this.servicePrices = servicePrices;
    }


    @Override
    public String toString() {
        return "Mã " + id +
                " Tên sản phẩm " + serviceName+
                " Gía sản phẩm " + servicePrices +
                " Số lượng " + amount ;
    }
}
