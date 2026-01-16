import java.util.Stack;

// Invoker - Order Processor with Command History
public class OrderProcessor {
    private Stack<Command> commandHistory;

    public OrderProcessor() {
        this.commandHistory = new Stack<>();
    }

    public void executeCommand(Command command) {
        command.execute();
        commandHistory.push(command);
    }

    // Cancel order by undoing all commands in reverse order
    public void cancelOrder() {
        System.out.println("\n--- Initiating Order Cancellation ---");
        System.out.println("Undoing " + commandHistory.size() + " operations in reverse order...");

        while (!commandHistory.isEmpty()) {
            Command command = commandHistory.pop();
            command.undo();
        }

        System.out.println("--- Order Cancellation Complete ---\n");
    }

    public int getHistorySize() {
        return commandHistory.size();
    }
}