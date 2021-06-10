import java.util.List;

public class RevenueManagement {
    List<Revenue> listRevenue;

    public RevenueManagement() {
    }

    public RevenueManagement(List<Revenue> listRevenue) {
        this.listRevenue = listRevenue;
    }

    public long monthlyRevenue(int month) {
        long total=0;
        for (Revenue revenue : listRevenue) {
            if (revenue.getTime().getMonthValue()==month){
                total+=revenue.getAmountOfMoney();
            }
        }
        return total;
    }
    public long revenueByDay(String date){
        return 0;
    }
}
