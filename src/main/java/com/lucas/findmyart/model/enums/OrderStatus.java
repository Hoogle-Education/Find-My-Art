package com.lucas.findmyart.model.enums;

import javax.validation.constraints.Null;
import java.util.Arrays;
import java.util.stream.Collectors;

public enum OrderStatus {
    WAITING_PAYMENT("waiting payment"),
    PAID("paid"),
    ON_THE_WAY("on the way"),
    DELIVERED("delivered"),
    CANCELED("canceled");

    public final String status;

    private OrderStatus(String status) {
        this.status = status;
    }

    public static OrderStatus valueOfStatus(String status) {
        return Arrays
                .stream(values())
                .filter(s -> s.name().equalsIgnoreCase(status))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }
}
