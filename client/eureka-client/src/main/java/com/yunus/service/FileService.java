package com.yunus.service;

import java.io.File;

/**
 * @Author: gaoyunfeng
 * @date: 2019/1/15
 */
public interface FileService {

    /**
     * 根据路径获取pdf 文件
     *
     * @param path 文件路径
     * @return
     */
    File getPdfFile(String path);
}
