package com.yunus.service.impl;

import com.yunus.service.FileService;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * @Author: gaoyunfeng
 * @date: 2019/1/15
 */
@Service
public class FileServiceImpl implements FileService {
    @Override
    public File getPdfFile(String path) {
        return new File("d:/test.pdf");
    }
}
