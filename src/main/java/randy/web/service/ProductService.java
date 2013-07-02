package randy.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import randy.core.spring.service.AbstractService;
import randy.web.domain.Product;

/**
 * 상품 서비스.
 * 
 * @author jace
 */
@Service
public class ProductService extends AbstractService {
	public static final String NAMESPACE = "product";

	/**
	 * 상품 목록을 얻는다.
	 * 
	 * @param product
	 * @return List<Category>
	 */
	public List<Product> getProductList(Product product) {
		return commonDao.selectList(NAMESPACE, "getProductList", product);
	}
}
