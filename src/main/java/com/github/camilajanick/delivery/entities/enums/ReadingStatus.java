package com.github.camilajanick.delivery.entities.enums;

public enum ReadingStatus {
    /*
     lido - lendo - não iniciado - abandonado
     */

    READ(1),
    READING(2),
    NOT_STARTED(3),
    ABANDONED(4);

    private int code;

    private ReadingStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ReadingStatus valueOf(int code) {
        for(ReadingStatus value : ReadingStatus.values()) {
            if(value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid ReadingStatus code");
    }
}
