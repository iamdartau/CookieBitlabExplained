package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //вернём все куки приложения
        Cookie cookies [] = request.getCookies();
        /*Куки разныъ браузеров и разных доменов не пересекаются
        * Они хранятся на стороне клиента в браузере
        * В виде текста как пара {ключ : значение}
        */
        String cookieValue = "No cookie Data";
                if(cookies !=null){
            for (Cookie cookie: cookies){
                //наш объект cookie из doPost  ↡
                //                             ↡
                if (cookie.getName().equals("cookiename")){
                    cookieValue = cookie.getValue();
                    break;
                }
            }
        }

        request.setAttribute("cookieValue", cookieValue);
        request.getRequestDispatcher("/home.jsp").forward(request,response);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String text = req.getParameter("cookiename");

                                /*cookie NAME  |  cookie VALUE
                                            ↡      ↡             */
        Cookie cookie = new Cookie("cookiename", text);
                /*    секунды
                          ↡  минуты
                          ↡    ↡  часы
                          ↡    ↡    ↡       */
        cookie.setMaxAge(60 * 60 * 24);
        resp.addCookie(cookie);
        resp.sendRedirect("/");

    }
}