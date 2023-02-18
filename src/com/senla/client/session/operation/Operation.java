package com.senla.client.session.operation;

import com.senla.exception.IllegalOperationArgumentException;

public enum Operation {
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;

    public static Operation getOperationByOrdinal(int ordinal) throws IllegalOperationArgumentException {
        return switch (ordinal) {
            case 1 -> Operation.INFO;
            case 2 -> Operation.DEPOSIT;
            case 3 -> Operation.WITHDRAW;
            case 4 -> Operation.EXIT;
            default -> throw new IllegalOperationArgumentException("Illegal operation argument.");
        };
    }
}
