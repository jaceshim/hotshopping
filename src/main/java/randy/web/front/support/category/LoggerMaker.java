package randy.web.front.support.category;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import randy.core.spring.util.SpringUtils;

public class LoggerMaker {
	
	static Logger logger = LoggerFactory.getLogger(LoggerMaker.class);
	
	/**
	 * siteId와 수집시점(onload, unload)를 구분짖는 suffix을 토대로 logger를 생성한다.
	 * 
	 * @param siteId
	 * @param suffix
	 * @return Logger
	 */
	@SuppressWarnings("unused")
	private static synchronized org.apache.log4j.Logger createLogger(String logFileName) throws Exception {

		
		String contextRootPath = SpringUtils.getContext().getRealPath("/");
		
		String logFilePath = contextRootPath + logFileName;
		logger.debug("--> file path : {}",  logFilePath);
		
		PatternLayout patternLayout = new PatternLayout("%m    %d{yyyy-MM-dd HH:mm:ss} %n");
		DailyRollingFileAppender appender = new DailyRollingFileAppender(patternLayout, logFilePath, ".yyyy-MM-dd");
		
		org.apache.log4j.Logger siteLogger = org.apache.log4j.Logger.getLogger(logFileName);
		
		siteLogger.setAdditivity(false);
		siteLogger.addAppender(appender);
		siteLogger.setLevel(Level.toLevel("info"));

		return siteLogger;
	}

}
