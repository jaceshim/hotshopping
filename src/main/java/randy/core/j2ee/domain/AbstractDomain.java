package randy.core.j2ee.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Domain 추상 클래스.
 * 
 * @author jace
 */
public abstract class AbstractDomain {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
