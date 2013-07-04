package randy.web.controller.rear;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import randy.web.domain.Category;
import randy.web.domain.CategoryTag;
import randy.web.service.CategoryService;

@Controller
public class CategoryController extends AbstractRearController {

	private static final String PATH = "/category/";
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 카테고리 TAG등록 화면
	 * 
	 * @param product
	 * @return
	 */
	@RequestMapping(PATH + "tag/insertForm")
	public String insertCategoryTagForm(Model model) {
		
		// 최상위 카테고리 호출.
		Category categoryParam = new Category();
		categoryParam.setPcateId(0);
		model.addAttribute("categoryList", categoryService.getCategoryList(categoryParam));
		
		return VIEW_PREFIX + "/category/insertCategoryTag";
	}
	
	/**
	 * 카테고리 TAG등록
	 * 
	 * @param product
	 * @return
	 */
	@RequestMapping(PATH + "tag/insert")
	public String insertCategoryTag(@ModelAttribute CategoryTag categoryTag, Model model) {
		
		categoryService.insertCategoryTag(categoryTag);
		
		return VIEW_PREFIX + "/category/insertCategoryTag";
	}	
	
	
}
