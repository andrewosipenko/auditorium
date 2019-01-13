package com.ao.auditorium.model.student;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Andrei Osipenko
 */
enum CourseInviteStatus {
    NEW(0),
    OPENED(1),
    CONFIRMED(2);

    private int value;
    private static Map map = new HashMap<>();

    CourseInviteStatus(int value) {
        this.value = value;
    }

    static {
        for (CourseInviteStatus status : CourseInviteStatus.values()) {
            map.put(status.value, status);
        }
    }

    public static CourseInviteStatus valueOf(int status) {
        return (CourseInviteStatus) map.get(status);
    }

    public int getValue() {
        return value;
    }
}
