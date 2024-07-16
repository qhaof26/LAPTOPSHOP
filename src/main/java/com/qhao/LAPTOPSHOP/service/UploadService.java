package com.qhao.LAPTOPSHOP.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;

@Service
public class UploadService {
    private final ServletContext servletContext;

    public UploadService(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    // logic: create absolute path -> create file name -> save file
    public String handleSaveUploadFile(MultipartFile file, String targetFile) {
        String finalNameFile = "";
        try {
            byte[] bytes = file.getBytes();
            // this.servletContext.getRealPath("")-> webapp =>
            // getRealPath("/resources/images")
            String rootPath = this.servletContext.getRealPath("/resources/images");

            File dir = new File(rootPath + File.separator + targetFile);
            // dir =E:\Code\SpringMVC\LAPTOPSHOP\src\main\webapp\resources\images\targetFile
            // File.separator == \
            if (!dir.exists())
                dir.mkdirs();
            // mkdirs: make directory
            // finalNameFile = millis second + Origin file name
            finalNameFile = System.currentTimeMillis() + "-" + file.getOriginalFilename();
            // Create the file on server
            File serverFile = new File(dir.getAbsolutePath() + File.separator + finalNameFile);

            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return finalNameFile;
    }
}
