package com.yunus.controller;

import com.yunus.feign.FileUploadFeignService;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @GetMapping("/createImageCode")
    public void stream(HttpServletResponse response) {
        Response imageCode = fileUploadFeignService.createImageCode();
        try (InputStream in = imageCode.body().asInputStream()) {
            byte[] buff = new byte[in.available()];
            in.read(buff);
            response.getOutputStream().write(buff);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
