package assign.servlets;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import assign.dbaccess.EMailAddressVOO;
import assign.dbaccess.EMailDBAccess;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;

/*
 * Get All Email Addresses by Group Servlet 
 */
@WebServlet("/GetAllEMailListbyGroupServlet")
public class GetAllEMailListbyGroupServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("GetAllEMailListbyGroupServlet servlet started");
		
		String errors = "";
		String groupID = request.getParameter("groupid");
		System.out.println("groupID: " + groupID);
		response.setContentType("text/html");
	
		EMailBO eMailBO = new EMailBO();
		ArrayList eMailAddress = null;
		EMailAddressVOO[] eMailList = null;

		try {
			ArrayList<EMailAddressVOO> emailAddress = eMailBO.getAllEMailAddressListbyGroup(groupID);
			// ArrayList emailAddress = eMailBO.getAllEMailAddressListbyGroup(groupID);
			
			  Object[] aList = emailAddress.toArray(new EMailAddressVOO[emailAddress.size()]); 
			  eMailList = new EMailAddressVOO[emailAddress.size()]; 
			  for (int i = 0;i < aList.length;i++)
			  {
			     eMailList[i] = (EMailAddressVOO) aList[i];
			     System.out.println(eMailList[i].geteMailID());
			   }
			 
			if (emailAddress != null && !emailAddress.isEmpty()) {
				System.out.println("Length of Emailaddress list:" + emailAddress.size());
				
				System.out.println();
				for (EMailAddressVOO email : emailAddress) {
					System.out.println("Email Id: " + email.geteMailID());
					System.out.println("First Name :" + email.getfName());
					System.out.println("MiddleName :" + email.getmName());
					System.out.println();

				}
				if (errors.equals("")) {
					request.getSession().setAttribute("emailList", eMailList);
					response.sendRedirect("/mysite/viewbygroupsuccess.jsp");
				} else {
					request.getSession().setAttribute("Errors", errors);
					response.sendRedirect("/mysite/error.jsp");
				}
			}

		} catch (EMailValidationException emve) {
			errors = emve.getErrorMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}

}
