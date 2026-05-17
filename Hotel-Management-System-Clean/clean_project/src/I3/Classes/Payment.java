package I3.Classes;

import java.util.ArrayList;

/**
 *
 * @author Faysal Ahmed
 */
public class Payment {
    
    //required Object
    private Booking booking;
    private ArrayList<ExtraOrders> orders;
    private int totalRentPrice;
    private int daysStayed;
    private String payment_date;
    private String payment_method;
    
    private boolean hasDiscount;
    private float discount;
    
    private int totalBill;
    public ArrayList<ExtraOrders> getOrders() { return orders; }
    public void setOrders(ArrayList<ExtraOrders> orders) { this.orders = orders; }
    public int getTotalRentPrice() { return totalRentPrice; }
    public void setTotalRentPrice(int totalRentPrice) { this.totalRentPrice = totalRentPrice; }
    public int getDaysStayed() { return daysStayed; }
    public void setDaysStayed(int daysStayed) { this.daysStayed = daysStayed; }
    public int getTotalBill() { return totalBill; }
    
    
    public Payment(Booking b)
    {
        booking = b;
        
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public boolean isHasDiscount() {
        return hasDiscount;
    }

    public void setHasDiscount(boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
    
    
    public int calculateTotalBill()
    {
        int orderTotal = 0;
        
        for(ExtraOrders order: orders)
        {
            orderTotal += order.getQuantity() * order.getItem().getPrice();
        }
        totalBill = orderTotal+ totalRentPrice;
        
        return totalBill;
    }
    
    
    
    
    
}
