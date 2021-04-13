package com.testcy.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {
    /*手写的demo获取文件上传的http协议报文body ：

    ServletInputStream inputStream = req.getInputStream();
        byte[] buffer=new byte[1024];
        StringBuffer stringBuffer = new StringBuffer();
        int read=0;
        while ( (read=inputStream.read(buffer))!=-1){
            stringBuffer.append(new String(buffer,0,read));
        }
        System.out.println(stringBuffer.toString());*/
    /*
            ------WebKitFormBoundarycidIguiRsIWPGx3H
            Content-Disposition: form-data; name="username"

            curry
            ------WebKitFormBoundarycidIguiRsIWPGx3H
            Content-Disposition: form-data; name="file"; filename="test.bmp"
            Content-Type: image/bmp


            ------WebKitFormBoundarycidIguiRsIWPGx3H--
        * */
            /*第三方jar包解析文件上传数据的常用api
        ServletFileUpload类，用于解析上传的数据，FileItem类表示每一个表单项
        //1、判断当前数据格式是否为文件上传协议格式
        * boolean isMultipartContent = ServletFileUpload.isMultipartContent(req);
        *2、解析上传的数据
        public List<FileItem> parseRequest(HttpServletRequest request)
        3、判断当前这个表单项是否为普通的表单项，还是文件上传的文本类型,返回true表示为普通表单项
        boolean FileItem.isFormField()
        4、//获取表单项的name属性值
        String FileItem.getFieldName()
        5、获取表单项的值
        String FileItem.getString()
        6、获取上传的文件名
        String FileItem.getName()
        7、将上传的文件写到服务器所指向的地址
        void FileItem.write(file)
        * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //判断上传的数据是否为文件数据
        boolean isMultipartContent = ServletFileUpload.isMultipartContent(req);
        if (isMultipartContent) {
            //创建fileItemFactory工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的ServletFileUpload实现工具类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                List<FileItem> fileItems = servletFileUpload.parseRequest(req);
                for (FileItem item : fileItems) {
                    if (item.isFormField()) {
                        //普通表单类型
                        System.out.println("表单项的name属性值：" + item.getFieldName());
                        System.out.println("表单项的value属性值：" + item.getString("utf-8"));


                    } else {
                        //文件上传的数据
                        System.out.println("表单项的name属性值：" + item.getFieldName());
                        System.out.println("上传的文件名：" + item.getName());
                        item.write(new File("D:\\testFile\\" + item.getName()));

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
