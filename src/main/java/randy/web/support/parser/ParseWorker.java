package randy.web.support.parser;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 파서를 실행시키는 worker클래스.
 * 
 * @author jace
 */
@Component
public class ParseWorker {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	private static Map<String, AbstractShopParser> parserMap = new ConcurrentHashMap<String, AbstractShopParser>();

	public void run() {
	}

	/**
	 * worker 초기화 진행.
	 * class loader에 의해 로드된 {@link AbstractShopParser} 를 구현한 클래스을 로드한다.
	 */
	@PostConstruct
	public void init() {
		// 파서 클래스 로딩
		Reflections reflections = new Reflections(this.getClass().getPackage().getName());
		Set<Class<? extends AbstractShopParser>> parsers = reflections.getSubTypesOf(AbstractShopParser.class);

		if (parsers != null) {
			logger.debug("-------------------------------------------------");
			int loadCount = 0;
			try {

				for (Class<? extends AbstractShopParser> item : parsers) {
					String parserName = null;
					AbstractShopParser parser = null;
					try {
						parser = item.newInstance();
						parserName = parser.getClass().getSimpleName();

						parser.init();
						
						// TODO: add dynamically schedule
						
						parserMap.put(parserName, parser);

					} catch (Exception e) {
						logger.error(item.getName() + " create error :" + e.getMessage(), e);
						throw e;
					}
					logger.debug(" load parser : " + parserName);

					loadCount++;
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			} finally {
				logger.debug("total parser load count : " + loadCount);
				logger.debug("-------------------------------------------------");
			}

		}
	}

	/**
	 * worker destory 수행.
	 */
	@PreDestroy
	public void destory() {
		
		// TODO: release spring task in parser class
		
	}

}
