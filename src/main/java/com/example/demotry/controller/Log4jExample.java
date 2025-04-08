package com.example.demotry.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class Log4jExample {

    private static final Logger logger = LogManager.getLogger(Log4jExample.class);
    /*
    TRACE: The finest level of logging, used to trace the execution of the program in great detail. This is useful for debugging, but generally generates a lot of output.

    DEBUG: Provides detailed information, typically useful only for developers during the debugging process. It’s more concise than TRACE but still provides useful information about program flow.

    INFO: General information about the application's operation, typically used to provide information on the system's state or milestones (e.g., when an application starts or finishes a task).

    WARN: Warnings about potential issues that aren't necessarily errors, but might need attention in the future. These typically indicate a problem that could become serious if left unaddressed.

    ERROR: Logs that indicate serious issues, typically when something has gone wrong in the application, and immediate attention is required.

    FATAL: The highest level of logging. Indicates severe errors that may cause the application to terminate. This level is typically used for critical failures.
    */

    @GetMapping("/log")
    public String log(){
        logger.trace("This is a TRACE message");
        logger.debug("This is a DEBUG message");
        logger.info("This is an INFO message");
        logger.warn("This is a WARN message");
        logger.error("This is an ERROR message");
        logger.fatal("This is a FATAL message");
        return "Log check";
    }
}
