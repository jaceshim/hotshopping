package randy.web.controller.rear;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import randy.core.j2ee.alert.AlertInfo;
import randy.core.j2ee.alert.AlertType;
import randy.web.domain.Category;
import randy.web.domain.CategoryTag;
import randy.web.service.CategoryService;

/**
 * 카테고리 콘트롤러.
 * 
 * @author jace
 */
@Controller
public class CategoryController extends AbstractRearController {

	private static final String PATH = "/category/";

	@Autowired
	private CategoryService categoryService;

	/**
	 * 카테고리 목록 화면
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(PATH + "list")
	public String getCategoryList(Model model) {

		// 카테고리 tree목록 호출.
		model.addAttribute("categoryList", categoryService.getCategoryTreeList(null));

		return VIEW_PREFIX + "/category/getCategoryList";
	}

	/**
	 * 카테고리 TAG등록 화면
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(PATH + "tag/insertform")
	public String insertCategoryTagForm(Model model) {

		// 최상위 카테고리 호출.
		Category categoryParam = new Category();
		categoryParam.setPcateId(0);
		model.addAttribute("categoryList", categoryService.getCategoryList(categoryParam));

		return VIEW_PREFIX + "/category/insertCategoryTag";
	}

	/**
	 * 카테고리 미등록 TAG목록 화면
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(PATH + "tag/unreg/list")
	public String getCategoryTagUnregList(Model model) {

		// 최상위 카테고리 호출.
		Category cateParam = new Category();
		cateParam.setPcateId(0);
		model.addAttribute("categoryList", categoryService.getCategoryList(cateParam));

		model.addAttribute("categoryUnregList", categoryService.getCategoryTagUnregList(null));

		return VIEW_PREFIX + "/category/getCategoryTagUnregList";
	}

	/**
	 * 카테고리 조회 화면
	 * 
	 * @param cateId
	 * @param model
	 * @return
	 */
	@RequestMapping(PATH + "{cateId}")
	public String getCategoryForAjax(@PathVariable Integer cateId, Model model) {

		Category cateParam = new Category();
		cateParam.setCateId(cateId);

		return VIEW_PREFIX + "/category/getCategory";
	}

	/**
	 * 카테고리 등록 화면
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(PATH + "insertform")
	public String insertCategoryFormForAjax(Model model) {

		return VIEW_PREFIX + "/category/insertCategoryForm";
	}

	/**
	 * 카테고리 등록
	 * 
	 * @param request
	 * @param category
	 * @param model
	 * @return
	 */
	@RequestMapping(PATH + "insert")
	public String insertCategory(HttpServletRequest request, @ModelAttribute Category category, Model model) {

		categoryService.insertCategory(category);

		// alert처리 정보생성.
		AlertInfo alertInfo = new AlertInfo();
		alertInfo.setAlertType(AlertType.ALERT_AND_GO);
		alertInfo.setMessage("message.insert.success");
		alertInfo.setRedirectUrl(VIEW_PREFIX + PATH + "list");

		return this.alert(request, alertInfo);
	}

	/**
	 * 카테고리 TAG등록
	 * 
	 * @param request
	 * @param categoryTag
	 * @param model
	 * @return
	 */
	@RequestMapping(PATH + "tag/insert")
	public String insertCategoryTag(HttpServletRequest request, @ModelAttribute CategoryTag categoryTag, Model model) {

		categoryService.insertCategoryTag(categoryTag);

		// alert처리 정보생성.
		AlertInfo alertInfo = new AlertInfo();
		alertInfo.setAlertType(AlertType.ALERT_AND_GO);
		alertInfo.setMessage("message.insert.success");
		alertInfo.setRedirectUrl(VIEW_PREFIX + PATH + "tag/list");

		return this.alert(request, alertInfo);
	}

}
