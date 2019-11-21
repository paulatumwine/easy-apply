package edu.mum.cs.easyapply.servlets.applicants;

import edu.mum.cs.easyapply.daos.applicants.ApplicantDAO;
import edu.mum.cs.easyapply.model.ApplicantData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DataController
 */
@WebServlet(name = "/DataController", urlPatterns = {"/applicant-save"})
public class DataController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicantData applicantFormData = (ApplicantData) request.getAttribute("applicantFormData");

        ApplicantDAO.saveApplicantFormData(applicantFormData);

        /*// todo redirect to correct location: login page or dashboard
        String baseUrl = String.format("%s://%s:%s%s", request.getScheme(), request.getServerName(),
                request.getServerPort(), request.getContextPath());
        response.sendRedirect(baseUrl + "/applicant-login");*/

        RequestDispatcher rd = request.getRequestDispatcher("/applicant-login");
        rd.forward(request, response);
    }

}
