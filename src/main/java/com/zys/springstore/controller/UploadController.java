package com.zys.springstore.controller;

import com.zys.springstore.proj.Result;
import com.zys.springstore.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;
    //本地存储wj
//    @PostMapping("/upload")
//    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
//        log.info("文件上传:{},{},{}",username,age,image);
//
//        //文件名
//        String originalFilename = image.getOriginalFilename();
//
//        //构造唯一文件名
//        int index = originalFilename.lastIndexOf(".");
//        String extname = originalFilename.substring(index);
//        String newFileName = UUID.randomUUID().toString() +extname;
//
//        log.info("新文件名:{}",newFileName);
//
//        //将文件存储在服务器的操盘中
//        image.transferTo(new File("D:\\programm\\java\\files\\"+ newFileName));
//        return Result.success();
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws Exception {

        log.info("文件上传，文件名字:{}",image.getOriginalFilename());
        String url = aliOSSUtils.upload(image);
        log.info("文件上传完成，文件访问的url:{}",url);

        return Result.success(url);
    }
}
