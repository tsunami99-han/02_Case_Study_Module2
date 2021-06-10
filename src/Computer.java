import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Computer {
    private int id;
    private String name;
    private long startTimeUse = 0;
    private long endTimeUse = 0;
    private int pricePerHour=7000;
    private boolean status = false;
    private HashMap<String, Long> mapService;
    private LocalDate systemTime;
    private long payments=0;

    public Computer() {
    }

    public Computer(int id, String name, int pricePerHour, HashMap<String, Long> mapService) {
        this.id = id;
        this.name = name;
        this.pricePerHour = pricePerHour;
        this.mapService = mapService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public HashMap<String, Long> getMapService() {
        return mapService;
    }

    public void setMapService(HashMap<String, Long> mapService) {
        this.mapService = mapService;
    }

    public LocalDate getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(LocalDate systemTime) {
        this.systemTime = systemTime;
    }

    public long getPayments() {
        return payments;
    }

    public void setPayments(long payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        if (this.status==false){
            return this.name + " is disable " + this.pricePerHour+"/1h.";
        }else {
            return this.name + " is avaiable" + this.pricePerHour+"/1h.";
        }
    }
}
