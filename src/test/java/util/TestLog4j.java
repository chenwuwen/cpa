package util;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestLog4j {
	private static Logger logger = Logger.getLogger(TestLog4j.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("web.root:"+ System.getProperty("web.root"));
		// 记录debug级别的信息  
        logger.debug("This is debug message.");  
        // 记录info级别的信息  
        logger.info("This is info message.");  
        // 记录error级别的信息  
        logger.error("This is error message.");  
    }
	}


