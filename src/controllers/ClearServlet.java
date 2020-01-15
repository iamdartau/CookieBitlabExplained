package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet("/delete")
public class ClearServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie [] cookies =request.getCookies();
        if(cookies !=null){
            for (Cookie c :
                    cookies) {
                //вытаскиваем имя нашего куки; мы его задали в homeServlet через String text;
                if(c.getName().equals("cookiename")){
                    //удалим куки
                    c.setMaxAge(0);
                    //вернём обратно
                    response.addCookie(c);
                    //завершаем цикл
                    break;
                }
            }
        }
        response.sendRedirect("/");
    }
}
