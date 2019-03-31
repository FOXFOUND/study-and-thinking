package com.foxfound.log.constant;

/**
 * @Description
 * @Author foxFound
 * @Date 2019-03-15
 */
public enum LogTypeEnum {
    EVENT_LOG(1),
    REQUEST_RESPONSE_LOG(2);
    private int logType;

    LogTypeEnum(int logType) {
        this.logType = logType;
    }

    public static LogTypeEnum getByValue(int value) {
        for (LogTypeEnum logTypeEnum : values()) {
            if (logTypeEnum.getLogType() == value) {
                return logTypeEnum;
            }
        }
        return null;
    }

    public int getLogType() {
        return logType;
    }
}
