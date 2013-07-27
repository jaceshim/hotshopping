package randy.core.j2ee.util;

import java.util.HashMap;

import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * config성격의 properties파일 정보 호출.
 * 
 * @author jace
 */
public class ConfigUtils extends PropertyPlaceholderConfigurer {

	private static Map<String, String> propertiesMap;

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props) throws BeansException {

		super.processProperties(beanFactory, props);

		propertiesMap = new HashMap<String, String>();
		for (Object key : props.keySet()) {
			String keyStr = key.toString();

			propertiesMap.put(keyStr, props.getProperty(keyStr));
		}
	}

	public static int getInt(String key) {
		return Integer.parseInt(getString(key));
	}

	public static boolean getBoolean(String key) {
		return Boolean.parseBoolean(getString(key));
	}

	public static double getDouble(String key) {
		return Double.parseDouble(getString(key));
	}

	public static float getFloat(String key) {
		return Float.parseFloat(getString(key));
	}

	public static long getLong(String key) {
		return Long.parseLong(getString(key));
	}

	public static String getString(String key) {
		return propertiesMap.get(key);
	}

}
