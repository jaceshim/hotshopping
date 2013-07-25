package randy.core.spring.util;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * i18n 메세지 호출 클래스.
 * 
 * @author jace
 */
@Component
public final class MessageUtils implements MessageSourceAware {

	private static MessageSource messageSource;

	@SuppressWarnings("static-access")
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public static String getMessage(String code) {
		return getMessage(code, "");
	}

	public static String getMessage(String code, String defaultMessage) {
		return messageSource.getMessage(code, null, defaultMessage, getLocale());
	}

	public static String getMessage(String code, Object[] args) {
		return getMessage(code, args, "");
	}

	public static String getMessage(String code, Object[] args, String defaultMessage) {
		return messageSource.getMessage(code, args, defaultMessage, getLocale());
	}

	public static Locale getLocale() {
		return LocaleContextHolder.getLocale();
	}

}
