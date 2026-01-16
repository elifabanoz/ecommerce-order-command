// ConcreteCommand - Update Inventory
public class UpdateInventoryCommand implements Command {
    private Order order;

    public UpdateInventoryCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.deductItems();
    }

    @Override
    public void undo() {
        order.restoreItems();
    }
}