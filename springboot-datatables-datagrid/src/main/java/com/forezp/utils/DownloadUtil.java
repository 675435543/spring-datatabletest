package com.forezp.utils;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;


/**
 * 下载文件
 * @author  lWX458995
 * @version  [版本号, 2018年8月16日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class DownloadUtil
{
    private static final Logger LOGGER = LoggerFactory.getLogger(DownloadUtil.class);
    
    /**
     * 下载静态资源路径下的模板
     * @param req
     * @param respon
     * @param filePath
     * @param fileName [参数说明]
     * 
     * @return void [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static void downloadFileStaticResource(HttpServletRequest req, HttpServletResponse respon, String filePath, String fileName)
    {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        InputStream inputStream = null;
        try
        {
            ClassPathResource classPathResource = new ClassPathResource(filePath + fileName);
            inputStream = classPathResource.getInputStream();
            respon.setContentType("application/x-excel");
            respon.setCharacterEncoding("UTF-8");
            respon.setHeader("Content-Disposition",
                "attachment;filename=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));
            //respon.setHeader("Content-Length", String.valueOf(f.length()));
            in = new BufferedInputStream(inputStream);
            out = new BufferedOutputStream(respon.getOutputStream());
            byte[] data = new byte[1024];
            int len = 0;
            while (-1 != (len = in.read(data, 0, data.length)))
            {
                out.write(data, 0, len);
            }
        }
        catch (FileNotFoundException e)
        {
        	LOGGER.error(e.getMessage());
        }
        catch (IOException e)
        {
        	LOGGER.error(e.getMessage());
        }
        finally
        {
        	if(null != inputStream){
        		try {
					inputStream.close();
				} catch (IOException e) {
					LOGGER.error(e.getMessage());
				}
        	}
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
        }
    }
    
    /**
     * 下载磁盘路径下的模板
     * @param req
     * @param respon
     * @param path
     * @param fileName [参数说明]
     * 
     * @return void [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static void downloadFile(HttpServletRequest req, HttpServletResponse respon,String path, String fileName)
    {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try
        {
            File f = new File(path+fileName);
            respon.setContentType("application/x-excel");
            respon.setCharacterEncoding("UTF-8");
            respon.setHeader("Content-Disposition",
                "attachment;filename=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));
            respon.setHeader("Content-Length", String.valueOf(f.length()));
            in = new BufferedInputStream(new FileInputStream(f));
            out = new BufferedOutputStream(respon.getOutputStream());
            byte[] data = new byte[1024];
            int len = 0;
            while (-1 != (len = in.read(data, 0, data.length)))
            {
                out.write(data, 0, len);
            }
        }
        catch (FileNotFoundException e)
        {
            LOGGER.error(e.getMessage());
        }
        catch (IOException e)
        {
            LOGGER.error(e.getMessage());
        }
        finally
        {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
        }
    }
    
    public static void uploadFile(HttpServletRequest request, String filePath, String fileName)
    {
        // TODO Auto-generated method stub
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> list = upload.parseRequest(request);
            for(FileItem item : list)
            {
                if(item.isFormField())
                {
                    String inputName = item.getFieldName();
                    String inputValue = item.getString();
                    LOGGER.info(inputName + "=" + inputValue);
                }
                else
                {
                    in = new BufferedInputStream(item.getInputStream());
                    out = new BufferedOutputStream(new FileOutputStream(filePath+fileName));
                    byte buffer[] = new byte[1024];
                    int len = 0;
                    while (-1 != (len = in.read(buffer, 0, buffer.length)))
                    {
                        out.write(buffer, 0, len);
                    }
                }
            }
        }catch(Exception e) {
            LOGGER.error(e.getMessage());
        }finally {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
        }
        
    }
}