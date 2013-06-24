package randy.core.spring.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * Dao 추상 클래스.
 * 
 * @author jace
 */
public abstract class AbstractDao extends SqlMapClientDaoSupport {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
}
