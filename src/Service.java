public class Service {
    private String serviceName;
    private long servicePrices;

    public Service() {
    }

    public Service(String serviceName, long servicePrices) {
        this.serviceName = serviceName;
        this.servicePrices = servicePrices;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public long getServicePrices() {
        return servicePrices;
    }

    public void setServicePrices(long servicePrices) {
        this.servicePrices = servicePrices;
    }
}
