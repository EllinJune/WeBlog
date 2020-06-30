package com.weblog.demo.demo.service.pzyservice;

import com.weblog.demo.demo.mapper.pzymapper.PhotoMapper;
import com.weblog.demo.demo.mapper.pzymapper.PhotoSortMapper;
import com.weblog.demo.demo.mapper.pzymapper.PhotoSortSetMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 服务
 * 创建相册，修改相册名，删除相册
 * 在相册中 上传图片，删除图片
 */
@Service
public class PhotoService {
    @Resource
    private PhotoMapper photoMapper;
    private PhotoSortMapper photoSortMapper;
    private PhotoSortSetMapper photoSortSetMapper;

}
