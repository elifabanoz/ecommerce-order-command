// ConcreteCommand - Process Logistics
public class ProcessLogisticsCommand implements Command {
    private Order order;

    public ProcessLogisticsCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.processToLogistics();
    }

    @Override
    public void undo() {
        order.cancelFromLogistics();
    }
}