package com.chacha.jsp.board.gugudan;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 요청 데이터 인코딩
        resp.setCharacterEncoding("UTF-8"); // 응답 데이터 인코딩
        resp.setContentType("text/html; charset=UTF-8"); // 브라우저에게 우리가 만든 결과물이 UTF-8이다. 라고 알리는 의미

        String danStr = req.getParameter("dan");
        String limitStr = req.getParameter("limit");

        int dan = Integer.parseInt(danStr);
        int limit = Integer.parseInt(limitStr);

        resp.getWriter().append("%s단, %s단까지".formatted(danStr, limitStr));
        resp.getWriter().append("<div>=== 구구단 %s단 ===</div>".formatted(danStr));
        for (int i = 1; i <= limit; i++) {
            resp.getWriter().append("<div>%d * %d = %d</div>".formatted(dan, i, dan * i));
        }
    }

}
