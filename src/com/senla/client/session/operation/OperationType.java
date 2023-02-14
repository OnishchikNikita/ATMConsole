package com.senla.client.session.operation;

import com.senla.client.session.exception.IllegalOperationArgumentException;

public enum OperationType {
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;

    public static OperationType getOperationByOrdinal(int ordinal) throws IllegalOperationArgumentException {
        return switch (ordinal) {
            case 1 -> OperationType.INFO;
            case 2 -> OperationType.DEPOSIT;
            case 3 -> OperationType.WITHDRAW;
            case 4 -> OperationType.EXIT;
            default -> throw new IllegalOperationArgumentException("Unexpected operation argument.");
        };
    }
}
