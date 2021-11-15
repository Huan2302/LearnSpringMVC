package com.vinaemter.BAI1.controllers;

import com.vinaemter.BAI1.dao.studentDao;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class studentController {
    @Autowired
     private studentDao studentDao;

    private ServletContext context;

    @GetMapping("/array")
    public String index(Model model) {
        model.addAttribute("array",studentDao.findAll());
        return "array";
    }

    @PostMapping("/saveImg")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam("file")MultipartFile file) {
            try {
                if (!file.isEmpty()){
                    String fileName = file.getOriginalFilename(); //lấy tên file
//                    System.out.println("fileName:" + fileName);
                    String getFile = getFileNameServer(fileName);
//                    System.out.println(getFile);
                    File fileRoot = pathFile(getFile,"img",request);
                    file.transferTo(fileRoot);  // truyền tải tệp tin
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        return "array";
    }

    //đặt lại tên file
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

    public File pathFile(String fileName,String folder,HttpServletRequest request){
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
