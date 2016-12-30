/**
 * 
 */
package net.qlbh.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * @author KISS
 *
 */
public class Common {
	public static String escapeHTML(String content) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < content.length(); i++) {
			char c = content.charAt(i);

			switch (c) {
			case '<':
				sb.append("&lt;");
				break;
			case '>':
				sb.append("&gt;");
				break;

			case '&':
				sb.append("&amp;");
				break;
			case '"':
				sb.append("&quot;");
				break;
			case '\'':
				sb.append("&apos;");
				break;
			default:
				sb.append(c);
			}
		}
		content = sb.toString();
		return content;
	}

	/**
	 * escapeInjection
	 *
	 * @param str
	 *            String
	 * @return String escapeInjection
	 */
	public static String escapeInjection(String str) {
		String tem = str.replace("'", "''");
		tem = tem.replace("\\", "\\\\");
		tem = tem.replace("\\\\", "\\\\\\\\");
		tem = tem.replace("%", "\\%");
		return tem;
	}

	/**
	 * checkLogin
	 *
	 * @param session
	 *            HttpSession
	 * @return ADM001
	 */
	public static boolean checkLogin(HttpSession session) {
		boolean result = false;
		if (session.getAttribute("username") != null) {
			result = true;
		}
		return result;

	}
	
	/**
     * @param totalUser tổng số user trong database
     * @param limit số user hiển thị trên 1 trang
     * @return tổng số trang user
     */
    public static int getTotalPage(int totalUser, int limit){
    	return (totalUser % limit == 0) ? (totalUser / limit) : (totalUser / limit + 1);
    }
    
    /**
     * @param totalRecord tổng số bản ghi lấy từ database
     * @param limit số user hiển thị trên 1 trang
     * @param currentPage trang hiện tại
     * @return List các số trang khi paging
     */
    public static List<Integer> getListPaging(int totalRecord, int limit, int currentPage){
    	List<Integer> result = new ArrayList<Integer>();
    	//get total page
    	int totalPage = getTotalPage(totalRecord, limit);
    	//get current group
    	int currentGroup = getCurrentGroup(currentPage);
    	//start page
    	int start = (currentGroup - 1) * Integer.parseInt(ConfigProperties.getData("numberPage")) + 1;
    	//end page
    	int end = (totalPage <= currentGroup * Integer.parseInt(ConfigProperties.getData("numberPage"))) ?
    			totalPage : currentGroup * Integer.parseInt(ConfigProperties.getData("numberPage"));
    	//list to return
    	for(int i = start; i <= end; i++){
    		result.add(i);
    	}
    	return result;
    }
    
    /**
     * @param currentPage : trang hiện tại
     * @param limit : số user hiển thị trên 1 trang
     * @return : vị trí user trong database bắt đầu trả về
     */
    public static int getOffset(int currentPage, int limit){
    	if(currentPage==0)
    		return 0;
    	else
    		return ((currentPage - 1) * limit );
    }
    /**
     * @return: trả về số user trên 1 trang kết quả
     */
    public static int getLimit(){
    	return Integer.parseInt(ConfigProperties.getData("numberRecordInPage"));
    }

    /**
     * @param currentPage : trang hiện tại
     * @return nhóm 3 trang cần hiển thị theo currentPage
     */
    public static int getCurrentGroup(int currentPage){
    	return (currentPage % Integer.parseInt(ConfigProperties.getData("numberPage")) == 0) ?
    			(currentPage / Integer.parseInt(ConfigProperties.getData("numberPage"))) :
    				(currentPage / Integer.parseInt(ConfigProperties.getData("numberPage")) + 1);
    }
}
