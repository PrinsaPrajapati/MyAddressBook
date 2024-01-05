package assign.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import assign.dbaccess.EMailAddressVOO;
import assign.dbaccess.EMailDBAccess;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;

/*
 * Get Email Address Servlet 
 */
@WebServlet("/GetEMailAddressDtlsForUpdateServlet")
public class GetEMailAddressDtlsForUpdateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
    	String errors = "";
    	//step1
    	String emailaddress = request.getParameter("emailid");
    	System.out.println("emailAddress:"+ emailaddress);
    	
    	//step2 JDBC
    	//2a
    	HttpSession session= request.getSession(true);
    	session.setAttribute("emailId", emailaddress);
    	
    	EMailBO eMailBO = new EMailBO();
		EMailAddressVOO eMailAddressVOO= null;
    	
    	//EMailAddressVOO eMailAddressVOO = null;
    	try {
    		eMailAddressVOO = eMailBO.getEMailAddress(emailaddress);
    		
		} catch (EMailValidationException e) {
			errors = e.getErrorMessage();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    	
		if (errors.equals("")) {
			System.out.println("first Name: " + eMailAddressVOO.getfName());
			request.setAttribute("emailVO", eMailAddressVOO);
			RequestDispatcher rd = request.getRequestDispatcher("/displayrecordupdate.jsp");
			rd.forward(request, response);
		} else {
			request.getSession().setAttribute("Errors", errors);
			response.sendRedirect("/mysite/modifycontact.jsp");
		}
    	
    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        doGet(request, response);
    }

}

