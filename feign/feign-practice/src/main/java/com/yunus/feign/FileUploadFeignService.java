package com.yunus.feign;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: gaoyunfeng
 * @date: 2018/12/8
 */
@FeignClient(value = "client-a")
public interface FileUploadFeignService {


    /**
     * feign 远程调用 文件上传
     *
     * @param file
     * @return
     */
    @PostMapping(value = "/file", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String fileUpload(@RequestPart(value = "file") MultipartFile file);

    /**
     * feign 返回图片流处理方式
     *
     * @param imagekey
     * @return
     */
    @GetMapping("/file/createImageCode")
    Response createImageCode();
}
