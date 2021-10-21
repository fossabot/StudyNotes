package app14;
/** 
* @description 新闻类
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月1日 上午9:10:50
* @version 1.0.0
*/
public class News extends Object {

	//新闻编号
	private int id;
	//新闻标题
	private String title;
	//新闻作者 
	private String creator;
	
	//无参构造方法
	public News(){}

	//有参构造方法
	public News(int id, String title, String creator) {
		this.id = id;
		this.title = title;
		this.creator = creator;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", creator=" + creator + "]";
	}
}
