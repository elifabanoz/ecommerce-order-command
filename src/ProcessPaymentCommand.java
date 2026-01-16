// ConcreteCommand - Process Payment
public class ProcessPaymentCommand implements Command {
    private Order order;

    public ProcessPaymentCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.processPayment();
    }

    @Override
    public void undo() {
        order.refundPayment();
    }
}