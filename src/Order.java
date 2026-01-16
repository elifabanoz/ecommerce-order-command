import java.util.List;

// Receiver - Order
public class Order {
    private String orderId;
    private List<String> items;
    private double totalAmount;
    private String status;
    private String paymentStatus;
    private String logisticsStatus;

    public Order(String orderId, List<String> items, double totalAmount) {
        this.orderId = orderId;
        this.items = items;
        this.totalAmount = totalAmount;
        this.status = "PENDING";
        this.paymentStatus = "UNPAID";
        this.logisticsStatus = "NOT_PROCESSED";
    }

    public void processPayment() {
        this.paymentStatus = "PAID";
        System.out.println("Order " + orderId + ": Payment processed - $" + totalAmount);
    }

    public void refundPayment() {
        this.paymentStatus = "REFUNDED";
        System.out.println("Order " + orderId + ": Payment refunded - $" + totalAmount);
    }

    public void processToLogistics() {
        this.logisticsStatus = "PROCESSING";
        this.status = "SHIPPED";
        System.out.println("Order " + orderId + ": Sent to logistics for delivery");
    }

    public void cancelFromLogistics() {
        this.logisticsStatus = "CANCELLED";
        this.status = "CANCELLED";
        System.out.println("Order " + orderId + ": Cancelled from logistics");
    }

    public void restoreItems() {
        System.out.println("Order " + orderId + ": Items restored to inventory: " + String.join(", ", items));
    }

    public void deductItems() {
        System.out.println("Order " + orderId + ": Items deducted from inventory: " + String.join(", ", items));
    }

    public void printStatus() {
        System.out.println("Order Status: [ID=" + orderId + ", Status=" + status +
                ", Payment=" + paymentStatus + ", Logistics=" + logisticsStatus + "]");
    }

    // Getters
    public String getOrderId() { return orderId; }
    public List<String> getItems() { return items; }
    public double getTotalAmount() { return totalAmount; }
    public String getStatus() { return status; }
    public String getPaymentStatus() { return paymentStatus; }
    public String getLogisticsStatus() { return logisticsStatus; }
}