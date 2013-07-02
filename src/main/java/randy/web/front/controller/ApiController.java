package randy.web.front.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import randy.core.spring.controller.AbstractController;
import randy.web.domain.Category;
import randy.web.domain.Product;
import randy.web.service.CategoryService;
import randy.web.service.ProductService;
import randy.web.support.api.ApiResult;
import randy.web.support.api.ApiStatus;

/**
 * API 콘트롤러.
 * 
 * @author jace
 */
@Controller
@RequestMapping("/api/*")
public class ApiController extends AbstractController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	/**
	 * 상품정보를 호출한다.
	 * 
	 * @param product
	 * @return
	 */
	@RequestMapping("/get/product")
	@ResponseBody	
	public ApiResult getProductList(@ModelAttribute Product product) {
		ApiResult result = new ApiResult();
		try {
			List<Product> data = productService.getProductList(product);
			if (data != null) {
				result.setStatus(ApiStatus.SUCCESS.getStatus());
				result.setData(data);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setStatus(ApiStatus.ERROR.getStatus());
		}

		return result;
	}

	/**
	 * 카테고리 정보를 호출한다.
	 * 
	 * @param category
	 * @return ApiResult
	 */
	@RequestMapping("/get/category")
	@ResponseBody
	public ApiResult getCategory(@ModelAttribute Category category) {

		ApiResult result = new ApiResult();
		try {
			List<Category> data = categoryService.getCategoryList(category);
			if (data != null) {
				result.setStatus(ApiStatus.SUCCESS.getStatus());
				result.setData(data);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setStatus(ApiStatus.ERROR.getStatus());
		}

		return result;
	}

}