package com.yunus.feign.rollback;

import com.yunus.feign.FileUploadFeignService;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: gaoyunfeng
 * @date: 2018/12/21
 */
@Service
@Slf4j
public class FileUploadFeignServiceImpl implements FileUploadFeignService {
    @Override
    public String fileUpload(MultipartFile file) {
        return "fail";
    }

    @Override
    public Response createImageCode() {
        log.info("调用远程方法失败");
        return Response.builder().build();
    }
}
