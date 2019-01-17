package com.yunus.controller;

import com.yunus.feign.FileUploadFeignService;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: gaoyunfeng
 * @date: 2018/12/21
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileUploadFeignService fileUploadFeignService;

    /**
     * 调用远程服务上传文件
     *
     * @param file
     * @return
     */
    @PostMapping(produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String upload(@RequestParam("file") MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        return fileUploadFeignService.fileUpload(file);
    }

    /**
     * 调用远程服务获取文件流
     *
     * @param response
     */
    @GetMapping(value = "/createImageCode", produces = {MediaType.APPLICATION_PDF_VALUE})
    public void stream(HttpServletResponse response) {
        Response imageCode = fileUploadFeignService.createImageCode();
        try (InputStream in = imageCode.body().asInputStream()) {
            ServletOutputStream out = response.getOutputStream();
            byte[] buff = new byte[1024];
            int len;
            while ((len = in.read(buff)) != -1) {
                out.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
