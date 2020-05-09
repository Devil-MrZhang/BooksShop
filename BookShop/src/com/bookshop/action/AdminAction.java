/**
 * 
 */
package com.bookshop.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bookshop.model.Product;
import com.bookshop.service.ProductService;
import com.bookshop.utils.PageResults;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

/**
 * @author 寮犲瀹�
 * @data 2020骞�4鏈�29鏃� 涓嬪崍5:57:28
 * @describe 
 */
@Controller
@Scope("prototype")
public class AdminAction extends ActionSupport {
	@Resource
	private ProductService service;
	private List<Product> books;
	private HttpServletRequest request;
	private HttpSession session;
	private int id;
	private String name;
	private  Product pp;
	private int pageNo;
	private String category2;
	private PageResults pageResults;
	private Product p;
	public AdminAction() {
		request=ServletActionContext.getRequest();
		session=request.getSession();
	}
	
	//鍟嗗搧id
	private int cid;
	//鍟嗗搧绫诲埆
	private String category;
	//鍟嗗搧鍚嶇О
	private String cname;
	//鏈�灏忎环
	private int minprice;
	//鏈�澶т环
	private int maxprice=1000;
	private Product pr;
	
	

	
	
	

	public String execute() throws Exception {
		books=service.findAll();
		System.out.println(books);
		return "list";
	}
	/*
	 * 鐢�
	 * 
	 * */
	public String check() {
		String add = "price > " + minprice + " and id > " + cid + " and price < " + maxprice;

		if (!category.equals("")) {

			add = add + " and category ='" + category + "'";
		}
		if (!cname.equals("")) {
			add = add + " and name like '%" + cname + "%'";
		}

		String sql = "from Product  where " + add;
		books = service.check(sql);
		System.out.println(books);
		return "check";
	}

	/**
	 * 
	 *@date 2020骞�5鏈�1鏃�
	  @describe 鍒犻櫎涔�
	 */
	public String delBook() {
		System.out.println("*****del*****"+cid);
		service.delBookById(cid);
		
		return "del";
		
	}
	/**
	 * 
	 *@date 2020骞�5鏈�1鏃�
	  @describe  鍒犻櫎鎵�閫変腑 鐨勪功
	 */
	public String delAll() {
		String[] ids = request.getParameterValues("ids");
		service.delAllBooks(ids);
		
		return "delAll";
	}
	
	/**
	 * 娣诲姞涔�
	 * @return
	 */
	public String addBooks(){
		
		service.addBooks(p);
		return "addBooks";
	}
	/**
	 * 璺宠浆鍒版洿鏂伴〉闈�
	 * @return
	 */
	public String toUpdate(){
		pr = service.getProductById(id);
		System.out.println(pr.getImg_url());
		return "toUpdate";
	}
	/**
	 * 缂栬緫鍚庢彁浜�
	 * @return
	 */
	public String update(){
		Product pro = service.getProductById(id);
		pro.setName(p.getName());
		pro.setPrice(p.getPrice());
		pro.setImg_url(p.getImg_url());
		pro.setPnum(p.getPnum());
		pro.setCategory(p.getCategory());
		pro.setDescription(p.getDescription());
		service.updateBooks(pro);
		return "input";
	}
	/**
	 * 汪
	 *@date 2020年5月5日
	  @describe 搜索框
	 */
	public String findPname() {
	 String qwe="findPname";
			    
		if(service.findProName(name)==null) {
			qwe= "findPnametuo";
		}else {
			pp=service.findProName(name);
		}		
		return qwe;
	}
		 
	/**
	 * 汪
	 *@date 2020年5月5日
	  @describe 全部商品
	 */
	public String findAllweb(){
		pageResults=service.findPageUser(pageNo);	
		books=pageResults.getResults();
		return "findAllweb";
	}
	/**
	 * 汪
	 *@date 2020年5月5日
	  @describe 分类商品
	 */
	public String findAllcategory(){
		pageResults=service.findPageProduct(pageNo, category2);	
		books=pageResults.getResults();
		return "findAllcategory";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Product getPp() {
		return pp;
	}
	public void setPp(Product pp) {
		this.pp = pp;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public String getCategory2() {
		return category2;
	}
	public void setCategory2(String category2) {
		this.category2 = category2;
	}
	public PageResults getPageResults() {
		return pageResults;
	}
	public void setPageResults(PageResults pageResults) {
		this.pageResults = pageResults;
	}
	public List<Product> getBooks() {
		return books;
	}

	public void setBooks(List<Product> books) {
		this.books = books;
	}
	public ProductService getService() {
		return service;
	}
	public void setService(ProductService service) {
		this.service = service;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getMinprice() {
		return minprice;
	}
	public void setMinprice(int minprice) {
		this.minprice = minprice;
	}
	public int getMaxprice() {
		return maxprice;
	}
	public void setMaxprice(int maxprice) {
		this.maxprice = maxprice;
	}
	public Product getP() {
		return p;
	}
	public void setP(Product p) {
		this.p = p;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getPr() {
		return pr;
	}
	public void setPr(Product pr) {
		this.pr = pr;
	}

	
}
