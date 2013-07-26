package randy.core.j2ee.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Spring관련 유틸클래스.
 * 
 * @author jace
 */
public final class SpringUtils implements ApplicationContextAware {

	private static ApplicationContext context;

	public static ApplicationContext getApplicationContext() {
		return context;
	}

	public static Object getBean(String beanName) {
		return getApplicationContext().getBean(beanName);
	}

	public static <T> T getBean(Class<T> type) {
		return getApplicationContext().getBean(type);
	}

	public static <T> T getBean(String beanName, Class<T> type) {
		return getApplicationContext().getBean(beanName, type);
	}

	public static boolean containsBean(String name) {
		return getApplicationContext().containsBean(name);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}

}
