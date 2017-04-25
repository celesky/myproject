    package com.flume;


    import org.apache.logging.log4j.LogManager;
    import org.apache.logging.log4j.Logger;

    /**
     * Created by pan on 2017/3/11.
     */
    public class DemoLog4j {
        private static Logger logger = LogManager.getLogger(Demo.class);
        public static void main(String[] args) {
            logger.error("hello!");
        }

    }
