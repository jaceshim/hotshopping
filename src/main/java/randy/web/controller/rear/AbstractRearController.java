package randy.web.controller.rear;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import randy.core.spring.controller.AbstractController;

/**
 * 관리자단 추상 콘트롤러.
 * 
 * @author jace
 */
@Controller
@RequestMapping("/rear/*")
public abstract class AbstractRearController extends AbstractController {

	protected static final String VIEW_PREFIX = "/rear/";
}
