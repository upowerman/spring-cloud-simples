package com.yunus.api;

import com.yunus.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Author: gaoyunfeng
 * @date: 2018/12/21
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileUpload(@RequestParam("file") MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        return "ok";
    }

    @GetMapping(value = "/createImageCode", produces = {MediaType.APPLICATION_PDF_VALUE})
    public void getStream(HttpServletResponse response) {
        File file = fileService.getPdfFile("d:/test.pdf");
        try (InputStream in = new FileInputStream(file)) {
            ServletOutputStream out = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
