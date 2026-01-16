import java.util.Arrays;

// Client - Main class demonstrating Command Pattern
public class Client {
    public static void main(String[] args) {
        // Create an order (Receiver)
        Order order = new Order("ORD-2024-001",
                Arrays.asList("Laptop", "Mouse", "Keyboard"),
                1599.99);
        System.out.println("Created Order:");
        order.printStatus();

        // Create the invoker
        OrderProcessor orderProcessor = new OrderProcessor();

        // Create commands
        Command paymentCommand = new ProcessPaymentCommand(order);
        Command inventoryCommand = new UpdateInventoryCommand(order);
        Command logisticsCommand = new ProcessLogisticsCommand(order);

        // Process the order (execute commands)
        System.out.println("\n--- Processing Order ---");
        orderProcessor.executeCommand(paymentCommand);
        orderProcessor.executeCommand(inventoryCommand);
        orderProcessor.executeCommand(logisticsCommand);

        System.out.println("\nOrder Status After Processing:");
        order.printStatus();
        System.out.println("Commands in history: " + orderProcessor.getHistorySize());

        // Simulate order cancellation after processing
        System.out.println("\n*** Customer requests cancellation ***");
        orderProcessor.cancelOrder();

        System.out.println("Final Order Status:");
        order.printStatus();

        // Demonstrate another scenario - partial processing
        System.out.println("\n========== SCENARIO 2: Partial Processing ==========\n");

        Order order2 = new Order("ORD-2024-002",
                Arrays.asList("Phone", "Case"),
                899.99);
        OrderProcessor processor2 = new OrderProcessor();

        processor2.executeCommand(new ProcessPaymentCommand(order2));
        processor2.executeCommand(new UpdateInventoryCommand(order2));

        System.out.println("\nOrder 2 Status (before logistics):");
        order2.printStatus();

        // Cancel before shipping
        System.out.println("\n*** Customer cancels before shipping ***");
        processor2.cancelOrder();

        System.out.println("Final Order 2 Status:");
        order2.printStatus();

        System.out.println("\n END OF DEMONSTRATION ");
    }
}
