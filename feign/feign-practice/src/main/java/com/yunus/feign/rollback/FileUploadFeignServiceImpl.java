package com.yunus.feign.rollback;

import com.yunus.feign.FileUploadFeignService;
import feign.Response;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: gaoyunfeng
 * @date: 2018/12/21
 */
@Service
public class FileUploadFeignServiceImpl implements FileUploadFeignService {
    @Override
    public String fileUpload(MultipartFile file) {
        return "fail";
    }

    @Override
    public Response createImageCode() {
        return Response.builder().build();
    }
}
