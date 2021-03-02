package gimtt.com;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.javafx.scene.control.skin.VirtualFlow.ArrayLinkedList;

import gimtt.com.modelas.CategoryDao;
import gimtt.com.modelas.CategoryModels;
import gimtt.com.modelas.CustomerDao;
import gimtt.com.modelas.CustomerModel;
import gimtt.com.modelas.PitemModel;
import gimtt.com.modelas.PitemsDao;
import gimtt.com.modelas.PorderDao;
import gimtt.com.modelas.PorderModel;
import gimtt.com.modelas.ProductDao;
import gimtt.com.modelas.ProductModel;
import gimtt.com.modelas.ShopDao;
import gimtt.com.modelas.ShopModel; 

/**
 * Servlet implementation class welcomeToMyPage
 */
public class welcomeToMyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public welcomeToMyPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String parameterValue = request.getParameter("choice");
		if (parameterValue==null){
			CategoryDao dao = new CategoryDao();
			CategoryModels models []= (CategoryModels[]) dao.getAll();
			request.setAttribute("CATMODELS", models);	
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request,response);
		}else if (parameterValue.equalsIgnoreCase("2")){
			RequestDispatcher rd = request.getRequestDispatcher("contactus.jsp");
			rd.forward(request, response);
		}else if (parameterValue.equalsIgnoreCase("login")){
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}else if (parameterValue.equalsIgnoreCase("about")){
			RequestDispatcher rd = request.getRequestDispatcher("aboutus.jsp");
			rd.forward(request, response);
		}else if (parameterValue.equalsIgnoreCase("4")){
			
			String cat = request.getParameter("cat");
			
			String catgory = request.getParameter("cat");
			ShopDao dao = new ShopDao();
			ShopModel models [] = (ShopModel[])dao.getShops(catgory);
			request.setAttribute("SHOPS", models);
			RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
			rd.forward(request, response);
		}else if (parameterValue.equalsIgnoreCase("5")){
			
			 
			String catgory = request.getParameter("cat");
			ProductDao dao = new ProductDao();
			ProductModel models [] = (ProductModel[])dao.getProducts(catgory);
			session.setAttribute("PRODUCTS", models);
			RequestDispatcher rd = request.getRequestDispatcher("displayitems.jsp");
			rd.forward(request, response);
		}else if (parameterValue.equalsIgnoreCase("7")){
			
			 
			String itemid = request.getParameter("itemid");
			String qty = request.getParameter("qchoice");
			CartModel model = new CartModel();
			model.setItemid(itemid);
			model.setQty(qty);
			
			ArrayList cart  = (ArrayList) session.getAttribute("CART");
			if(cart == null){
				cart = new ArrayList();
			}
			
			cart.add(model);
			session.setAttribute("CART", cart);
			
			RequestDispatcher rd = request.getRequestDispatcher("displayitems.jsp");
			rd.forward(request, response);
		}else if (parameterValue.equalsIgnoreCase("showcart")){
			ArrayList cart  = (ArrayList) session.getAttribute("CART");
			
			ProductDao dao = new ProductDao();
			for (Iterator iterator = cart.iterator(); iterator.hasNext();) {
				CartModel model = (CartModel) iterator.next();
				String id = model.getItemid();
				ProductModel pmodel =(ProductModel)dao.getModel(id);
				model.setItemName(pmodel.getName());
				model.setPrice(pmodel.getPrice());
				model.calculateAmount();
				
				
				
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("showcart.jsp");
			rd.forward(request, response);
		}else if (parameterValue.equalsIgnoreCase("checkout")){
			RequestDispatcher rd = request.getRequestDispatcher("customer.jsp");
			rd.forward(request, response);
		}else if (parameterValue.equalsIgnoreCase("place_order")){
			String name = request.getParameter("name");
			String emailId = request.getParameter("emailid");
			String sphone = request.getParameter("phone");
		    Long phone = Long.parseLong(sphone);
			String address = request.getParameter("address");
			CustomerModel cmodel = new CustomerModel();
			cmodel.setName(name);
			cmodel.setEmail_ID(emailId);
			cmodel.setPhoneNO(phone);
			cmodel.setAddress(address);
			
			CustomerDao cdao = new CustomerDao();
			CustomerModel savedmodel= (CustomerModel)cdao.save(cmodel);
			int cid = savedmodel.getId();
			
			PorderModel pomodel = new PorderModel();
			pomodel.setUseridfk(cid);
			pomodel.setDate(new Date(new java.util.Date().getYear(), new java.util.Date().getMonth(), new java.util.Date().getDay()));
			
			ArrayList<CartModel> cart =(ArrayList<CartModel>) session.getAttribute("CART");
			int total =0;
			for (Iterator iterator = cart.iterator(); iterator.hasNext();) {
				CartModel cartModel = (CartModel) iterator.next();
				cartModel.calculateAmount();
				total = total+cartModel.getTotalAmount();
			}
			pomodel.setTotal(total);
			PorderDao odao = new PorderDao();
			  pomodel= (PorderModel)odao.save(pomodel);
			int pid = pomodel.getId();
			
			
			
			session.invalidate();
			PitemsDao itemdao = new PitemsDao();
			int gtotalAmout=0;
			for (Iterator iterator = cart.iterator(); iterator.hasNext();) {
				CartModel cartModel = (CartModel) iterator.next();
				PitemModel itemModel = new PitemModel();
				gtotalAmout = gtotalAmout+cartModel.getPrice();
				itemModel.setPrice(cartModel.getPrice());
				itemModel.setProductfk(cartModel.getItemid());
				itemModel.setUseridfk(cid);
				int quantity = Integer.parseInt(cartModel.getQty());
				itemModel.setQuantity(quantity);
				itemModel.setOrderFk(pid);
				//pmodel.setUseridfk(1);
				
				itemModel.calculateTotal();
				itemdao.save(itemModel);
				
			}
			RequestDispatcher rd = request.getRequestDispatcher("thankyou.jsp");
			rd.forward(request, response);
		}
		// TODO Auto-generated method stub
//		response.getWriter().append("Tejas at: ").append(request.getContextPath());
//	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//	rd.forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
