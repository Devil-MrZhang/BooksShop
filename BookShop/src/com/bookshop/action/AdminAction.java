/**
 * 
 */
package com.bookshop.action;

import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
	private int bookid=0;
	//鍟嗗搧鍚嶇О
	private String cname;
	//鏈�灏忎环
	private int minprice;
	//鏈�澶т环
	private int maxprice=1000;
	private Product pr;
	private int pp;
	//所调用方法名字
	private String whj;
	//上传的文件名
	private String fileFileName;
	//上传的文件
	private File file;
	

	
	
	

	public String execute() throws Exception {
		books=service.findAll();
		
		for (int i = 0; i < books.size(); i++) {
			Product product = books.get(i);
			String value = product.getCategory();
			switch (value) {
			case "1":
				product.setCategory("文学");
				break;
			case "2":
				product.setCategory("生活");
				break;
			case "3":
				product.setCategory("计算机");
				break;
			case "4":
				product.setCategory("外语");
				break;
			case "5":
				product.setCategory("经营");
				break;
			case "6":
				product.setCategory("励志");
				break;
			case "7":
				product.setCategory("社科");
				break;
			case "8":
				product.setCategory("学术");
				break;
			case "9":
				product.setCategory("少儿");
				break;
			case "10":
				product.setCategory("艺术");
				break;
			case "11":
				product.setCategory("原版");
				break;
			case "12":
				product.setCategory("科技");
				break;
			case "13":
				product.setCategory("考试");
				break;
			case "14":
				product.setCategory("生活百科");
				break;

			default:
				break;
			}
		}
		System.out.println("list-------------"+books);
	
		return "list";
	}
	/*
	 * 鐢�
	 * 
	 * */
	public String check() {
		String add = "price > " + minprice  + " and price < " + maxprice;

		if (!(bookid==0)) {

			add = add + " and category ='" + bookid + "'";
		}
		if (!cname.equals("")) {
			add = add + " and name like '%" + cname + "%'";
		}
		if (!(cid==0)) {
			add = add + " and id = " + cid;
		}

		String sql = "from Product  where " + add;
		books = service.check(sql);
		for (int i = 0; i < books.size(); i++) {
			Product product = books.get(i);
			String value = product.getCategory();
			switch (value) {
			case "1":
				product.setCategory("文学");
				break;
			case "2":
				product.setCategory("生活");
				break;
			case "3":
				product.setCategory("计算机");
				break;
			case "4":
				product.setCategory("外语");
				break;
			case "5":
				product.setCategory("经营");
				break;
			case "6":
				product.setCategory("励志");
				break;
			case "7":
				product.setCategory("社科");
				break;
			case "8":
				product.setCategory("学术");
				break;
			case "9":
				product.setCategory("少儿");
				break;
			case "10":
				product.setCategory("艺术");
				break;
			case "11":
				product.setCategory("原版");
				break;
			case "12":
				product.setCategory("科技");
				break;
			case "13":
				product.setCategory("考试");
				break;
			case "14":
				product.setCategory("生活百科");
				break;

			default:
				break;
			}}
		
		System.out.println(books);
		return "list";
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
	 * @throws Exception 
	 */
	public String addBooks(){


		String dirPath = ServletActionContext.getServletContext().getRealPath("upload");
		fileFileName=UUID.randomUUID()+".jpg";
		File target=new File(dirPath+"/"+fileFileName);
		file.renameTo(target);
		p.setImg_url("upload"+"/"+fileFileName);
		service.addBooks(p);
		System.out.println(target);
		System.out.println("------"+"上传的文件名"+fileFileName);
		return"addBooks";
	}
	/**
	 * 璺宠浆鍒版洿鏂伴〉闈�
	 * @return
	 */
	public String toUpdate(){
		pr = service.getProductById(id);
		
		category=pr.getCategory();
		
		
		
		
		return "toUpdate";
	}
	/**
	 * 缂栬緫鍚庢彁浜�
	 * @return
	 */
	public String update(){
		
		System.out.println("1111111111111"+category);
		
		String dirPath = ServletActionContext.getServletContext().getRealPath("upload");
		fileFileName=UUID.randomUUID()+".jpg";
		File target=new File(dirPath+"/"+fileFileName);
		file.renameTo(target);
		System.out.println("update-----------"+fileFileName);
		
		Product pro = service.getProductById(id);
		pro.setName(p.getName());
		pro.setPrice(p.getPrice());
		pro.setImg_url("upload"+"/"+fileFileName);
		pro.setPnum(p.getPnum());
		pro.setCategory(category);
		pro.setDescription(p.getDescription());
		
		System.out.println("updata********************"+dirPath+"/"+fileFileName);
		
		service.updateBooks(pro);
		System.out.println("updata");
		return "update";
	}
	
	/**
	 * 汪
	 *@date 2020年5月5日
	  @describe 搜索框
	 */
	public String findPname() {
	 whj="findPname";						 		
	 String names="%"+name+"%";	 
	 pageResults=service.findProName(pageNo, names);	
	 books=pageResults.getResults();
	 pp=books.size();
		
	    
	return "findPname";
	}
		 
	/**
	 * 汪
	 *@date 2020年5月5日
	  @describe 全部商品
	 */
	public String findAllweb(){
		whj="findAllweb";
		pageResults=service.findPageUser(pageNo);	
		books=pageResults.getResults();
		 pp=books.size();
		return "findAllweb";
	}
	/**
	 * 汪
	 *@date 2020年5月5日
	  @describe 分类商品
	 */
	public String findAllcategory(){
		whj="findAllcategory";
		pageResults=service.findPageProduct(pageNo, category2);	
		books=pageResults.getResults();
		 pp=books.size();
		return "findAllcategory";
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
	public String getWhj() {
		return whj;
	}
	public void setWhj(String whj) {
		this.whj = whj;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPp() {
		return pp;
	}
	public void setPp(int pp) {
		this.pp = pp;
	}
	public int getPageNo() {
		return pageNo;
	}
	
	
	
	
	
	

	
}
