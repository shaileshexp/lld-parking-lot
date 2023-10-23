package com.scaler.parkinglot.Model;

import java.util.HashMap;
import java.util.Map;

public enum VehicleType {

    SMALL("small", 1),
    MEDIUM("medium", 2),

    LARGE("large", 3);

    private String type;
    private int slotsrequire;

    VehicleType(String type, int slotsrequire) {
        this.type = type;
        this.slotsrequire = slotsrequire;
    }

    private static final Map<String, Integer> byType = new HashMap<>();
    static {
        for (VehicleType e : VehicleType.values()) {
            if (byType.put(e.type, e.slotsrequire) != null) {
                throw new IllegalArgumentException("duplicate id: " + e.byType);
            }
        }
    }

    public int numberOfSlots(VehicleType type){
      return byType.get(type.name().toLowerCase());
    }
}
