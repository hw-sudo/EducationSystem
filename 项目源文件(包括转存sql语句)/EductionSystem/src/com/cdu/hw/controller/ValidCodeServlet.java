package com.cdu.hw.controller;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/validCode")
public class ValidCodeServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);
        Random random = new Random();
        int code = 1000 + random.nextInt(9000);

        HttpSession session = req.getSession();
        session.setAttribute("validCode", String.valueOf(code));

        int width = 60;
        int height = 24;
        BufferedImage img=new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        Graphics g=img.getGraphics();

        g.setColor(Color.gray);
        g.fillRect(0,0,width,height);
        g.setColor(Color.blue);
        g.setFont(new Font("Arial",Font.BOLD,24));
        g.drawString(String.valueOf(code),5,20);

        ImageIO.write(img,"png",resp.getOutputStream());

    }
}
