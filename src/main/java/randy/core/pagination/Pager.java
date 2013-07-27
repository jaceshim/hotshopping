package randy.core.pagination;

import java.io.Serializable;
import java.util.Collection;

import randy.core.j2ee.util.ConfigUtils;

/**
 * 페이징
 * 
 * @author jace
 *
 */
public class Pager<T> implements Serializable {

	private Collection<T> items;

	private static final int DEFAULT_ROW_COUNT = ConfigUtils.getInt("global.page.default-row-count");

	private static final int DEFAULT_PAGE_COUNT = ConfigUtils.getInt("global.page.default-page-count");

	/** 현재 페이지 */
	private int currentPage;
	/** 총 개수 */
	private int totalCount;
	/** 페이지 번호가 화면에 보여질 개수 ex) [1], [2], [3].. [10] */
	private int pageUnit;
	/** 한 페이지에 보여질 row 개수 */
	private int pageSize;
	/** 최대 페이지 번호 (전체 페이지 개수) */
	private int maxPage;
	/** 화면에 보여지는 페이지번호의 처음 페이지번호 */
	private int firstPage;
	/** 화면에 보여지는 페이지번호의 마지막 페이지번호 */
	private int lastPage;

	public Pager(Collection<T> items, int currentPage, int totalCount) {
		this(items, currentPage, totalCount, DEFAULT_ROW_COUNT);
	}

	public Pager(Collection<T> items, int currentPage, int totalCount, int rowCount) {
		this(items, currentPage, totalCount, rowCount, DEFAULT_PAGE_COUNT);
	}

	public Pager(Collection<T> items, int currentPage, int totalCount, int rowCount, int pageUnit) {
		this.totalCount = totalCount;
		this.rowCount = rowCount;
		this.pageUnit = pageCount;
		this.maxPage = rowCount == 0 ? this.totalCount : (totalCount - 1) / rowCount + 1;
		this.currentPage = currentPage > maxPage ? maxPage : currentPage;
		this.firstPage = ((currentPage - 1) / pageCount) * pageCount + 1;
		this.lastPage = firstPage + (pageCount - 1);
	}

	public boolean hasNextPage() {
		return currentPage < maxPage;
	}

	public boolean hasPreviousPage() {
		return currentPage > 1;
	}

	public int getNextPage() {
		return currentPage + 1;
	}

	public void setNextPage(int val) {
		// not called
	}

	public int getPreviousPage() {
		return currentPage - 1;
	}

	public void setPreviousPage(int val) {
		// not called
	}

	public boolean hasNextPage() {
		return lastPage < maxPage;
	}

	public boolean hasPrevPage() {
		return currentPage >= pageCount + 1;
	}

	public int getStartOfNextPageUnit() {
		return endUnitPage + 1;
	}

	public int getStartOfPreviousPageUnit() {
		return beginUnitPage - 1;
	}

	public int getPageOfNextPageUnit() {
		return (currentPage + pageunit < maxPage) ? currentPage + pageunit : maxPage;
	}

	public int getPageOfPreviousPageUnit() {
		return (currentPage - pageunit > 1) ? currentPage - pageunit : 1;
	}

	public int getCurrentPage() {
		return this.currentPage;
	}

	public int getBeginUnitPage() {
		return this.beginUnitPage;
	}

	public int getEndListPage() {
		return (endUnitPage > maxPage) ? this.maxPage : this.endUnitPage;
	}

	public void setEndListPage(int val) {
		// not called.
	}

	public int getSize() {
		return objects.size();
	}

	public boolean isEmptyPage() {
		return (this.objects == null || this.getSize() == 0) ? true : false;
	}

	public void setEmptyPage(boolean val) {
		// not called.
	}

	/*--------------------------------------------
	 * define getter, setter 
	 *---------------------------------------------*/
	public Collection<T> getItems() {
		return items;
	}

	public void setItems(Collection<T> items) {
		this.items = items;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

}
