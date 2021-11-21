package com.vinaemter.BAI1.controllers;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UploadfileController {

    @RequestMapping("/multi-upload")
    public String load(){
        return "upload-file";
    }

    @RequestMapping(value = "/multi-upload",method = RequestMethod.POST)
    public ModelAndView upload(@RequestParam("file") List<MultipartFile> listFile,HttpServletRequest request){
        List<String> listFileName = new ArrayList<>();
        ModelAndView mav = new ModelAndView("upload-file");
        if (!listFile.isEmpty()){
            for (MultipartFile file:listFile){
                String fileName = file.getOriginalFilename(); //lấy tên file
                String getFile = getFileNameServer(fileName);
                File fileRoot = pathFile(getFile,"img",request);
                try {
                    file.transferTo(fileRoot);
                    listFileName.add(getFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        mav.addObject("listFileName",listFileName);
        return mav;
    }

    public String getFileNameServer(String fileName){
        if (!StringUtils.isEmpty(fileName)){
            String extention = FilenameUtils.getExtension(fileName);
            String base = FilenameUtils.getBaseName(fileName);
            StringBuilder builder = new StringBuilder();
            builder.append(base).append("-").append(System.nanoTime()).append(".").append(extention);
            return builder.toString();
        }
        return StringUtils.EMPTY;
    }

    public File pathFile(String fileName, String folder, HttpServletRequest request){
        String rootPath = request.getServletContext().getRealPath(""); // trả về đường dẫn tuyệt đối của web(target)
        System.out.println("rootPath:"+rootPath);
        System.out.println("folder:"+folder);
        File disry = new File(rootPath+folder); // đường dẫn folder
        if (!disry.exists()){
            disry.mkdirs();
        }
        File file = new File(rootPath+folder+"/"+fileName);
        System.out.println("filePath:"+rootPath+folder+"/"+fileName);
        return file;
    }
}
