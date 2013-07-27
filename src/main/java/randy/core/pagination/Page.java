package randy.core.pagination;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import randy.core.j2ee.util.ConfigUtils;
import randy.core.j2ee.util.SpringUtils;
import freemarker.template.Template;

/**
 * 페이지 아이템
 * 
 * @author jace
 *
 * @param <T>
 */
public class Page<T> implements Serializable {

	private static final long serialVersionUID = -4234639773749160197L;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private static final int DEFAULT_ROW_PER_PAGE = ConfigUtils.getInt("global.page.default-row-per-page");

	/** 시작 Page 번호 */
	private int startRow;
	/** 이전 Page 번호 */
	private int prevPageRow;
	/** 다음 Page 번호 */
	private int nextPageRow;
	/** 페이지블럭의 시작 페이지 번호 */
	private int blockFirstPage;
	/** 페이지블럭의 마지막 페이지 번호 */
	private int blockLastPage;
	/** 현재 Page 번호 */
	private int currentPage;
	/** 마지막 Page 번호 */
	private int lastPage;
	/** 마지막 Page의 Row */
	private int lastPageRow;
	/** 페이지당 Row 수 */
	private int rowPerPage;
	/** 블럭당 페이지 수 */
	private int pagePerBlock;
	/** 전체 Row 수 */
	private int totalRow;
	/** 페이지 아이템 */
	private Collection<T> items;
	/** 페이지 html */
	private String pageHtml;
	
	public Page(Collection<T> items, int totalRow, int startRow) {
		this(items, totalRow, startRow, DEFAULT_ROW_PER_PAGE);
	}

	public Page(Collection<T> items, int totalRow, int startRow, int rowPerPage) {

		pagePerBlock = ConfigUtils.getInt("global.page.default-page-per-block");
		if (rowPerPage <= 0) {
			this.rowPerPage = DEFAULT_ROW_PER_PAGE;
		} else {
			this.rowPerPage = rowPerPage;
		}

		this.totalRow = totalRow;
		this.startRow = startRow;

		this.items = items;

		if (rowPerPage == 0) {
			return;
		}

		if (startRow == 0) {
			startRow = 1;
		}

		currentPage = ((int)Math.ceil((double)startRow / (double)rowPerPage));

		lastPage = (int)Math.ceil((double)getTotalRow() / (double)rowPerPage);

		if (lastPage < currentPage) {
			currentPage = lastPage;
		}

		if (currentPage <= pagePerBlock) {
			blockFirstPage = 1;
			blockLastPage = pagePerBlock;
		} else {

			int tempFirstPage = (currentPage % pagePerBlock);

			// 페이지 블럭의 마지막 페이지를 클릭한 경우임.
			if (tempFirstPage == 0) {

				blockFirstPage = (currentPage - pagePerBlock) + 1;
				blockLastPage = currentPage;
			} else {
				blockFirstPage = currentPage - (currentPage % pagePerBlock) + 1;
				blockLastPage = (currentPage + pagePerBlock) - (currentPage % pagePerBlock);
			}
		}

		// 마지막 페이지보다 블럭 마지막 페이지가 큰 경우 마지막 페이지값을 블럭값으로 지정.
		if (blockLastPage > lastPage) {
			blockLastPage = lastPage;
		}

		/*
		// 블럭 시작 페이지 세팅
		blockFirstPage = currentPage - (int)Math.floor(pagePerBlock / 2);

		if (blockFirstPage < 1)
			blockFirstPage = 1;

		// 블럭 끝 페이지 세팅
		blockLastPage = blockFirstPage + pagePerBlock - 1;
		

		if (blockLastPage > lastPage)
			blockLastPage = lastPage;

		// 블럭 시작 페이지 보정
		if (blockFirstPage > blockLastPage - pagePerBlock + 1)
			blockFirstPage = blockLastPage - pagePerBlock + 1;

		if (blockFirstPage < 1)
			blockFirstPage = 1;
		*/

		/* 다음, 이전 페이지 세팅 */
		if (currentPage > 1) {
			prevPageRow = (currentPage - 2) * rowPerPage + 1;
		} else {
			prevPageRow = 0;
		}

		if (currentPage < lastPage) {
			nextPageRow = (currentPage) * rowPerPage + 1;
		} else {
			nextPageRow = 0;
		}

		lastPageRow = (lastPage - 1) * rowPerPage + 1;

	}

	/**
	 * 페이지 객체를 페이지UI html변환하여 반환한다.
	 * 
	 * @return
	 */
	public String getPageHtml() {
		
		String resultHtml = "";

		StringWriter stringWriter = null;
		try {
			FreeMarkerConfigurer config = SpringUtils.getBean(FreeMarkerConfigurer.class);

			stringWriter = new StringWriter();

			Template template = config.getConfiguration().getTemplate(ConfigUtils.getString("global.page.template"));

			template.process(this, stringWriter);

			resultHtml = stringWriter.toString();

		} catch (Exception ignore) {
			//nothing...
		} finally {
			try {
				stringWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return resultHtml;
	}

	/*---------------------------------------------------------------
	 * below setter, getter method.
	 *---------------------------------------------------------------*/

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getPrevPageRow() {
		return prevPageRow;
	}

	public void setPrevPageRow(int prevPageRow) {
		this.prevPageRow = prevPageRow;
	}

	public int getNextPageRow() {
		return nextPageRow;
	}

	public void setNextPageRow(int nextPageRow) {
		this.nextPageRow = nextPageRow;
	}

	public int getBlockFirstPage() {
		return blockFirstPage;
	}

	public void setBlockFirstPage(int blockFirstPage) {
		this.blockFirstPage = blockFirstPage;
	}

	public int getBlockLastPage() {
		return blockLastPage;
	}

	public void setBlockLastPage(int blockLastPage) {
		this.blockLastPage = blockLastPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getLastPageRow() {
		return lastPageRow;
	}

	public void setLastPageRow(int lastPageRow) {
		this.lastPageRow = lastPageRow;
	}

	public int getRowPerPage() {
		return rowPerPage;
	}

	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public int getPagePerBlock() {
		return pagePerBlock;
	}

	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public Collection<T> getItems() {
		return items;
	}

	public void setItems(Collection<T> items) {
		this.items = items;
	}

}
