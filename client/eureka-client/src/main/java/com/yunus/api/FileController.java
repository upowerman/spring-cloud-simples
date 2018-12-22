package com.yunus.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: gaoyunfeng
 * @date: 2018/12/21
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileUpload(@RequestParam("file") MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        return "ok";
    }

    @GetMapping("/createImageCode")
    public void getStream(HttpServletRequest request, HttpServletResponse response) throws IOException {
        File file = new File("e:/head.jpg");
        try (FileInputStream in = new FileInputStream(file)) {
            ServletOutputStream out = response.getOutputStream();
            byte[] buff = new byte[in.available()];
            in.read(buff);
            out.write(buff);
        }
    }
}
