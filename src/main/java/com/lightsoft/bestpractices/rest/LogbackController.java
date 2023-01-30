package com.lightsoft.bestpractices.rest;


import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * log api
 *
 * @author lipeng
 */
@RequestMapping("/api/log")
@RestController
@Slf4j
public class LogbackController {


    /**
     * logback动态修改包名的日志级别
     *
     * @return 当前的日志级别
     * @throws Exception
     */
    @PostMapping(value = "/setlevel")
    public String updateLogbackLevel() throws Exception {
//        ch.qos.logback.classic.LoggerContext loggerContext =(ch.qos.logback.classic.LoggerContext) LoggerFactory.getILoggerFactory();
//        Logger logger= null;
//        if(packageName.equals("-1")) {
//            // 默认值-1，更改全局日志级别；否则按传递的包名或类名修改日志级别。
//            logger=  loggerContext.getLogger("root");
//        } else {
//            logger= loggerContext.getLogger(packageName);
//        }
//        logger.setLevel(ch.qos.logback.classic.Level.toLevel(level));


        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        // 2. 修改指定logger对象的日志级别(这里根据你自己的日志名称修改，我的叫"my_logger")
        // 如果修改mybatis、spring框架的日志，写"org.mybatis"、"org.springframework"
        loggerContext.getLogger("root").setLevel(Level.valueOf("ERROR"));
        log.info("set log level to error");
        return loggerContext.toString();
    }

    @RequestMapping(value = "/level/error", method = RequestMethod.GET)
    @ResponseBody
    public String updateLogbackLevelToError() {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        loggerContext.getLogger("root").setLevel(Level.toLevel("ERROR"));
        return "修改package{}的logback{}级别成功";
    }

    @RequestMapping(value = "/level/info", method = RequestMethod.GET)
    @ResponseBody
    public String updateLogbackLevelToInfo() {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        loggerContext.getLogger("root").setLevel(Level.toLevel("INFO"));
        return "修改package{}的logback{}级别成功";
    }
}
