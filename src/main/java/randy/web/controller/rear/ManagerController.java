package randy.web.controller.rear;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import randy.web.service.ManagerService;

/**
 * 관리자 관련 콘트롤러.
 * 
 * @author jace
 */
@Controller
public class ManagerController extends AbstractRearController {

	private static final String PATH = "/manager/";
	
	@Autowired
	ManagerService managerService;	

	/**
	 * 로그인 화면
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(PATH + "loginform")
	public String loginForm(Model model) {

		return VIEW_PREFIX + PATH + "login";
	}

	/**
	 * 로그인 처리.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(PATH + "login")
	public String login(Model model) {

		//TODO: 관리자 로그인 체크 구현.

		return REDIRECT + "/rear/main";
	}

}
