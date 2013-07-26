package randy.core.pagination;

import java.io.Serializable;
import java.util.Collection;

/**
 * 페이지 아이템
 * 
 * @author jace
 *
 * @param <T>
 */
public class PageItems<T> implements Serializable {

	/** 시작 Page 번호 */
	int startRow;
	/** 이전 Page 번호 */
	int prevPageRow;
	/** 다음 Page 번호 */
	int nextPageRow;
	/** 페이지블럭의 시작 페이지 번호 */
	int blockFirstPage;
	/** 페이지블럭의 마지막 페이지 번호 */
	int blockLastPage;
	/** 현재 Page 번호 */
	int currentPage;
	/** 마지막 Page 번호 */
	int lastPage;
	/** 마지막 Page의 Row */
	int lastPageRow;
	/** 페이지당 Row 수 */
	int rowPerPage;
	/** 블럭당 페이지 수 */
	int pagePerBlock;
	/** 전체 Row 수 */
	int totalRow;

	Collection<T> pageItems;

}
