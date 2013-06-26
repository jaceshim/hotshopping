package randy.web.front.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import randy.core.spring.controller.AbstractController;
import randy.web.domain.Category;
import randy.web.front.service.CategoryService;
import randy.web.front.support.api.ApiResult;
import randy.web.front.support.api.ApiStatus;

/**
 * API 콘트롤러.
 * 
 * @author jace
 */
@Controller
public class ApiController extends AbstractController {

	private CategoryService categoryService;

	/**
	 * 어플설치 후 최초 디바이스 정보 등록
	 * 
	 * @param device
	 * @param model
	 * @return ResponseBodyData
	 */
	@RequestMapping(value = "/api/get/category")
	@ResponseBody
	public ApiResult getCategory(@RequestParam String pcateId) {

		ApiResult result = new ApiResult();
		try {
			List<Category> data = categoryService.getCateList(Integer.parseInt(pcateId));
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
