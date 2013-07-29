package randy.web.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import randy.core.j2ee.service.AbstractService;
import randy.core.pagination.Page;
import randy.web.domain.Category;
import randy.web.domain.CategoryTag;
import randy.web.domain.CategoryTagUnreg;
import randy.web.domain.TestBbs;

/**
 * 카테고리 서비스
 * 
 * @author jace
 */
@Service
public class CategoryService extends AbstractService {

	public static final String NAMESPACE = "category" + ".";

	/**
	 * 각 부모카테고리 하위 카테고리를 tree형태의 목록으로 조회한다. 
	 * 
	 * @param category
	 * @return List<Category>
	 */
	public List<Category> getCategoryTreeList(Category category) {
		if (category == null) {
			category = new Category();
		}
		return commonDao.selectList(NAMESPACE + "getCategoryTreeList", category);
	}

	/**
	 * 주어진 카테고리를 부모로 하는 하위 카테고리 목록을 얻는다.
	 * 
	 * @param category
	 * @return List<Category>
	 */
	public List<Category> getCategoryList(Category category) {
		if (category == null) {
			category = new Category();
		}
		return commonDao.selectList(NAMESPACE + "getCategoryList", category);
	}

	/**
	 * 신규 카테고리 등록
	 * 
	 * @param category
	 * @return Integer
	 */
	public Integer insertCategory(Category category) {

		if (StringUtils.isEmpty(category.getUseYn())) {
			category.setUseYn("Y");
		}
		commonDao.insert(NAMESPACE + "insertCategory", category);

		return category.getCateId();
	}

	/**
	 * 주어진 카테고리 아디디의 태그 목록을 얻는다.
	 * 
	 * @param categoryTag
	 * @return List<CategoryTag>
	 */
	public List<CategoryTag> getCategoryTagList(CategoryTag categoryTag) {
		if (categoryTag == null) {
			categoryTag = new CategoryTag();
		}
		return commonDao.selectList(NAMESPACE + "getCategoryTagList", categoryTag);
	}

	/**
	 * 카테고리 태그 등록
	 * 
	 * @param categoryTag
	 * @return Integer
	 */
	public Integer insertCategoryTag(CategoryTag categoryTag) {
		commonDao.insert(NAMESPACE + "insertCategoryTag", categoryTag);
		return categoryTag.getSeq();
	}

	/**
	 * 카테고리 미 등록 태그 목록을 얻는다.
	 * 
	 * @param categoryTag
	 * @return List<CategoryTagUnreg>
	 */
	public List<CategoryTagUnreg> getCategoryTagUnregList(CategoryTagUnreg categoryTagUnreg) {
		if (categoryTagUnreg == null) {
			categoryTagUnreg = new CategoryTagUnreg();
		}
		return commonDao.selectList(NAMESPACE + "getCategoryTagUnregList", categoryTagUnreg);
	}

	/**
	 * 카테고리 미 등록 태그 목록을 얻는다.
	 * 
	 * @param categoryTag
	 * @return List<CategoryTagUnreg>
	 */
	public Page<CategoryTagUnreg> getCategoryTagUnregPageList(CategoryTagUnreg categoryTagUnreg) {
		if (categoryTagUnreg == null) {
			categoryTagUnreg = new CategoryTagUnreg();
		}
		// 페이지당 100개씩 노출.
		categoryTagUnreg.setPageSize(100);
		return commonDao.selectPageList(NAMESPACE + "getCategoryTagUnregPageList", categoryTagUnreg);
	}

	/**
	 * 페이징 테스트용.
	 * 
	 * @param params
	 * @return
	 */
	public Page<TestBbs> getTestList(TestBbs params) {

		params.setPageSize(1000);

		return commonDao.selectPageList(NAMESPACE + "getTestList", params);
	}
}
