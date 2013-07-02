package randy.web.support.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 파싱 스케쥴러.
 * 
 * @author jace
 */
@Component
public class ParsingScheduler {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//@Scheduled(fixedRate=60*1000*60) // 60분에 한번식 실행.
	public void run() {
		logger.debug("--> 실행됨...");
	}

}
