/**
 * 
 */
package com.bookshop.action;

import java.io.File;
import java.util.Iterator;
import java.util.List;

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
		System.out.println(books);
		return "list";
	}
	/*
	 * 鐢�
	 * 
	 * */
	public String check() {
		String add = "price > " + minprice  + " and price < " + maxprice;

		if (!category.equals("")) {

			add = add + " and category ='" + category + "'";
		}
		if (!cname.equals("")) {
			add = add + " and name like '%" + cname + "%'";
		}
		if (!(cid==0)) {
			add = add + " and id = " + cid;
		}

		String sql = "from Product  where " + add;
		books = service.check(sql);
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
	 */
	public String addBooks(){
		
		service.addBooks(p);
		
					//确定上传文件目录
				    File filePath=new File("G:\\桌面\\快捷\\Images");
				    if(!filePath.exists()){
				    filePath.mkdirs();
				}
				   //确定临时文件目录
				   File tempFilePath=new File("G:\\桌面\\快捷\\Images\\buffer\\");
				   if(!tempFilePath.exists()){
				   tempFilePath.mkdirs();
				}
				try{
				   //创建文件工厂
				  DiskFileItemFactory factory=new  DiskFileItemFactory();
				  factory.setSizeThreshold(4096);//设置缓冲区大小，这里是4kb
				  factory.setRepository(tempFilePath);//设置缓冲目录
				  //创建上传文件操作对象
				  ServletFileUpload upload=new  ServletFileUpload(factory);
				  //限定上传文件大小
				  upload.setSizeMax(4194304);//设置最大文件尺寸，这里是4MB
				  //得到所有的请求上传文件
				  List<FileItem>items=upload.parseRequest(request);
				  Iterator<FileItem>i=items.iterator();
				        while(i.hasNext()){
					        FileItem fi=(FileItem)i.next();
					        //检查当前项目是普通表单项目还是上传文件
					        if(fi.isFormField()){
						        //如果是普通表单项目，现实表单内容
						        String fieldName=fi.getFieldName();
						        //对应submit.html中的type="text"name="name"
						        if(fieldName.equals("p.img_url")){
							        //显示表单内容
							        System.out.print("the field name is:" + fi.getString());
						        }else{
							        //如果是上传文件，显示文件名，
						        	System.out.print("the upload name is:" + fi.getName());
						        	System.out.print("<br>");
							        String fileName=fi.getName();
							        if(fileName!=null){
								        File fullFile=new File(fi.getName());
								        File savedFile=new File(filePath,fullFile.getName());
								        fi.write(savedFile);
								        System.out.print("上传成功");
							        }
						        }
						        System.out.print("<br>");
					        }
				        }
			    }catch(Exception e){
			    	e.printStackTrace();
			    }
		return "addBooks";
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
