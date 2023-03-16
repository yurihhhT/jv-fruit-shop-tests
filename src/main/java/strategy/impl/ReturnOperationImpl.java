package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class ReturnOperationImpl implements OperationHandler {
    private static final int DEFAULT_QUANTITY = 0;

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        if (!fruitTransaction.getOperation().equals(FruitTransaction.Operation.RETURN)) {
            throw new RuntimeException("Operation is not return");
        } else {
            int amount = Storage.map.getOrDefault(fruitTransaction.getFruit(), DEFAULT_QUANTITY);
            Storage.map.put(fruitTransaction.getFruit(), amount + fruitTransaction.getQuantity());
        }
    }
}
