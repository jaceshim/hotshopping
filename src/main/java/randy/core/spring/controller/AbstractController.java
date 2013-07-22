package randy.core.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.RequestContextUtils;

import randy.core.spring.alert.AlertInfo;
import randy.core.spring.util.MessageUtils;

/**
 * Controller 추상 클래스.
 * 
 * @author jace
 */
public abstract class AbstractController {

	protected static final String REDIRECT = "redirect:";
	protected static final String FORWARD = "forward:";

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * view단 alert처리.
	 * 
	 * @param request
	 * @param alertInfo
	 * @return String
	 */
	protected String alert(HttpServletRequest request, AlertInfo alertInfo) {

		FlashMap flashMap = RequestContextUtils.getOutputFlashMap(request);

		flashMap.put("redirectUrl", alertInfo.getRedirectUrl());
		flashMap.put("alertType", alertInfo.getAlertType().getType());

		String messageKey = alertInfo.getMessage();
		String[] messageArgs = alertInfo.getMessageArgs();
		String message = MessageUtils.getMessage(messageKey, messageArgs);
		// 해당 message key에 대한 값이 없는 경우 넘어온 message를 그냥 출력.
		if (message == null || message.length() == 0) {
			message = messageKey;
		}

		flashMap.put("message", alertInfo.getMessage());
		flashMap.put("params", alertInfo.getParams());
		/*
		Map<String, Object> params = alertInfo.getParams();
		if (params != null && params.size() > 0) {
			for (String key : params.keySet()) {
				flashMap.put(key, params.get(key));
			}
		}*/

		return REDIRECT + MessageUtils.getMessage("global.alert.url");
	}
}
