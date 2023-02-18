package org.example.domain;

public enum TaskState {
    TODO(0, "todo"),
    PENDING(1, "pending"),
    PROGRESS(2, "progress"),
    DONE(3, "done"),
    CANCELLED(4, "cancelled"),
    CLOSED(5, "closed");

    private final int value;
    private final String name;

    TaskState(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static TaskState fromInteger(int value) {
        for (TaskState state : TaskState.values()) {
            if (state.getValue() == value) {
                return state;
            }
        }
        throw new IllegalArgumentException("Integer value could not be mapped to an enum value" + value);
    }

    public static TaskState fromString(String name) {
        for (TaskState state : TaskState.values()) {
            if (state.getName().equals(name)) {
                return state;
            }
        }
        throw new IllegalArgumentException("String value could not be mapped to an enum value" + name);
    }
}
