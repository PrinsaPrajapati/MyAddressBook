package assign.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import assign.dbaccess.EMailAddressVOO;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;
@WebServlet("/UpdateEmailAddressSevlet")
public class UpdateEmailAddressSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public UpdateEmailAddressSevlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String errors = "";
	     HttpSession session= request.getSession(false);
	     
	     String inEmailID = (String) session.getAttribute("emailId");
		//EMailAddressVOO emailVO=(EMailAddressVOO)session.getAttribute("emailVO");
		EMailAddressVOO emailVO = new EMailAddressVOO();
		System.out.println("Inside Update Servlet");
		//String inEmailID = request.getParameter("emailid");
		System.out.println("Email Id: "+inEmailID);
        response.setContentType("text/html");

	       EMailBO eMailBO = new EMailBO();
	       EMailAddressVOO eMailAddress = null;

		emailVO.seteMailID(inEmailID);
		emailVO.setfName(request.getParameter("fName"));
		emailVO.setmName(request.getParameter("mName"));
		emailVO.setlName(request.getParameter("lName"));
		emailVO.sethPhone(request.getParameter("hphone"));
		emailVO.setwPhone(request.getParameter("wphone"));
		emailVO.setmPhone(request.getParameter("mphone"));
		emailVO.setgroupID(request.getParameter("groupID"));
		
		System.out.println("FirstName:"+emailVO.getfName());
		System.out.println("MiddelName:"+emailVO.getmName());
		System.out.println("LastName:"+emailVO.getlName());
		System.out.println("HomePhone:"+emailVO.gethPhone());
		System.out.println("WorkPhone:"+emailVO.getwPhone());
		System.out.println("MobilePhone:"+emailVO.getmPhone());
		System.out.println("GroupID:"+emailVO.getgroupID());
		

		try {
			
			eMailBO.updateEMailAddress(emailVO);
			
		}
		catch(EMailValidationException emve) {
			errors =emve.getErrorMessage();
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(errors.equals("")) {
			response.sendRedirect("/mysite/home.jsp");
		}else {
			request.getSession().setAttribute("Errors", errors);
			response.sendRedirect("/mysite/addcontact.jsp");
			}
	}

}
