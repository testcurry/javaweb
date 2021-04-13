package com.testcy.servlet;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取下载的文件名  注意此处模拟服务器上的资源，文件名不能有中文，服务器一般都是Linux系统
        String downloadFileName="test.jpg";
        //2、通过servletContext对象读取下载的内容
        ServletContext servletContext = getServletContext();
        //获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/file/" + downloadFileName);
        System.out.println("下载文件类型："+mimeType);
        //4、回传文件给客户端之前还要通过设置响应头给客户端，要回传的类型mimetype
        resp.setContentType(mimeType);
        //5、告诉客户端获取的数据是用于下载使用，而不是直接显示在客户端
        //文件名不支持中文，如果含有中文，谷歌和IE则要将文件名进行urlencoded编码，火狐要进行Base64编码
//        resp.setHeader("Content-Disposition","attachment;filename="+downloadFileName);
        //url编码是将汉字转换为%xx%xx xx为16进制
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode("桌面壁纸","UTF-8")+".jpg");
        //使用base64编码方式 该方式已不支持！
//        BASE64Encoder base64Encoder = new BASE64Encoder();
//        resp.setHeader("Content-Disposition","attachment;filename=?utf-8?B?"+ base64Encoder.encode("桌面壁纸.jpg".getBytes("utf-8"))+"?=");
        //3、把下载的数据回传到客户端
        //斜杠“/”被服务器解析表示http://localhost:8080/工程名/  映射到代码的web目录
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFileName);
        //获取响应输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        //读取下载的文件输入流，复制到文件输出流，输出给客户端
        IOUtils.copy(resourceAsStream, outputStream);


    }
}
