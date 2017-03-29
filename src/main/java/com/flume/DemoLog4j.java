    package com.flume;


    import org.apache.log4j.Logger;

    /**
     * Created by pan on 2017/3/11.
     */
    public class DemoLog4j {
        private static Logger logger = Logger.getLogger(DemoLog4j.class);
        public static void main(String[] args) {
            logger.error("hello!");
        }

    }
