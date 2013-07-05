package randy.core.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import randy.core.spring.alert.AlertType;
import randy.core.spring.util.MessageUtils;

/**
 * Controller 추상 클래스.
 * 
 * @author jace
 */
public abstract class AbstractController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	protected String alert(String directUrl, AlertType alertType) {
		return "redirect:" + MessageUtils.getMessage("global.alert.url");
	}
}
