package randy.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import randy.core.spring.service.AbstractService;
import randy.web.domain.Category;
import randy.web.domain.CategoryTag;

/**
 * 카테고리 서비스
 * 
 * @author jace
 */
@Service
public class CategoryService extends AbstractService {

	public static final String NAMESPACE = "category";

	/**
	 * 주어진 카테고리를 부모로 하는 하위 카테고리 목록을 얻는다.
	 * 
	 * @param category
	 * @return List<Category>
	 */
	public List<Category> getCategoryList(Category category) {
		return commonDao.selectList(NAMESPACE, "getCategoryList", category);
	}

	/**
	 * 주어진 카테고리 아디디의 태그 목록을 얻는다.
	 * 
	 * @param categoryTag
	 * @return List<CategoryTag>
	 */
	public List<CategoryTag> getCategoryTagList(CategoryTag categoryTag) {
		return commonDao.selectList(NAMESPACE, "getCategoryTagList", categoryTag);
	}
}