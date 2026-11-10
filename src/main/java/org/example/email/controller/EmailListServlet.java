package org.example.email.controller;

import org.example.email.model.User;
import org.example.email.model.UserDB;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        // Xu ly du lieu tieng Viet theo UTF-8
        request.setCharacterEncoding("UTF-8");

        // 1. Nhan thong tin ca nhan
        String firstName = getValue(request, "firstName");
        String lastName = getValue(request, "lastName");
        String email = getValue(request, "email");
        String dateOfBirth = getValue(request, "dateOfBirth");

        // 2. Nhan lua chon radio button
        String hearAboutUs = getValue(request, "hearAboutUs");

        // 3. Nhan lua chon checkbox
        // Checkbox khong duoc chon se tra ve null
        boolean emailAnnouncements =
                "yes".equals(request.getParameter("emailAnnouncements"));

        boolean postalAnnouncements =
                "yes".equals(request.getParameter("postalAnnouncements"));

        // 4. Nhan phuong thuc lien he
        String contact = getValue(request, "contact");

        // 5. Tao doi tuong User
        User user = new User(
                firstName,
                lastName,
                email,
                dateOfBirth,
                hearAboutUs,
                emailAnnouncements,
                postalAnnouncements,
                contact
        );

        // 6. Luu thong tin nguoi dung
        UserDB.insert(user);

        // 7. Gui doi tuong User sang trang JSP
        request.setAttribute("user", user);

        // 8. Chuyen sang trang cam on
        request.getRequestDispatcher("/thanks.jsp")
                .forward(request, response);
    }

    // Ham lay du lieu an toan, tranh loi khi gia tri null
    private String getValue(
            HttpServletRequest request,
            String parameterName
    ) {

        String value = request.getParameter(parameterName);

        if (value == null) {
            return "";
        }

        return value.trim();
    }
}
