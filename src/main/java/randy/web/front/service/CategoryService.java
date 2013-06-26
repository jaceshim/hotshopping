package randy.web.front.service;

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
	/**
	 * 주어진 카테고리를 부모로 하는 하위 카테고리 목록을 얻는다.
	 * 
	 * @param pcateId
	 * @return List<Category>
	 */
	public List<Category> getCateList(int pcateId) {

		Category category = new Category();
		category.setPcateId(pcateId);

		return commonDao.selectList("getCateList", category);
	}

	/**
	 * 주어진 카테고리 아디디의 태그 목록을 얻는다.
	 * 
	 * @param cateId
	 * @return List<CategoryTag>
	 */
	public List<CategoryTag> getCateTagList(int cateId) {

		CategoryTag categoryTag = new CategoryTag();
		categoryTag.setCateId(cateId);

		return commonDao.selectList("getCateTagList", categoryTag);
	}
}
