
package com.shopsphere.controller;

import java.io.IOException;
import java.util.List;

import com.shopsphere.dao.AddressDAO;
import com.shopsphere.model.Address;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddressServlet extends HttpServlet {

    private AddressDAO addressDAO;

    @Override
    public void init() {
        addressDAO = new AddressDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        int userId = (Integer) session.getAttribute("userId");

        List<Address> addresses = addressDAO.getAddressesByUserId(userId);
        request.setAttribute("addresses", addresses);

        request.getRequestDispatcher("/addresses.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        int userId = (Integer) session.getAttribute("userId");

        Address address = new Address();
        address.setUserId(userId);
        address.setAddressLine(request.getParameter("addressLine"));
        address.setCity(request.getParameter("city"));
        address.setState(request.getParameter("state"));
        address.setPincode(request.getParameter("pincode"));
        address.setAddressType(request.getParameter("addressType"));

        boolean saved = addressDAO.addAddress(address);

        if (saved) {
            response.sendRedirect(request.getContextPath()
                    + "/addresses?saved=true");
        } else {
            response.sendRedirect(request.getContextPath()
                    + "/addresses?saved=false");
        }
    }
}
