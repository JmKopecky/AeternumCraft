package com.jmkopecky.aeternumcraft.util;

import com.mojang.logging.LogUtils;

public enum Logger {

    DEBUG("Shows in a debug instance."),
    INFO("Used for minor information."),
    WARNING("Used for possible problems, not as severe as errors."),
    ERROR("Used for major problems that will likely cause problems."),
    TRACE("Lowest importance, very specific use.");


    private final String description;
    public static final org.slf4j.Logger LOGGER = LogUtils.getLogger();
    Logger(String desc) {
        this.description = desc;
    }

    public String getDescription() {
        return description;
    }


    public static void log(String toLog, Logger type) {
        switch (type) {
            case TRACE -> LOGGER.trace(toLog);
            case DEBUG -> LOGGER.debug(toLog);
            case INFO -> LOGGER.info(toLog);
            case WARNING -> LOGGER.warn(toLog);
            case ERROR -> LOGGER.error(toLog);
            default -> LOGGER.warn("Error in the log system; type: " + type.name() + " is not recognized as a type of log.");
        }
    }
}
