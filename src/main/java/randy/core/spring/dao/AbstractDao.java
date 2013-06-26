package randy.core.spring.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Dao 추상 클래스.
 * 
 * @author jace
 */
public abstract class AbstractDao extends SqlSessionDaoSupport {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
}
