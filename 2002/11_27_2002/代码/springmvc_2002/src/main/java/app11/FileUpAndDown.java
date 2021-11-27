package app11;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileUpAndDown {

    /**
     * 文件上传的前提
     *  1.表单为POST请求
     *  2.文本框为file类型（文件域）
     *  3.enctype属性值为multipart/form-data
     */
    @RequestMapping(value = "/fileUpload",method = RequestMethod.POST)
    public String testUpload(HttpServletRequest request,
                             @RequestParam(value = "desc",required = false) String desc,
                             @RequestParam("photo") CommonsMultipartFile[] fileList) throws Exception{
        System.out.println("desc->" + desc);
        //获取ServletContext对象（代表当前的WEB应用）
        ServletContext servletContext = request.getServletContext();
        //获取文件上传的真实路径
        String realPath = servletContext.getRealPath("/upload");
        System.out.println("realPath->" + realPath);
        //实例化文件对象
        File file1 = new File(realPath);
        //判断是否存在该目录
        if (!file1.exists()){
            //创建目录
            file1.mkdir();
        }
        //遍历上传的文件数组
        for (CommonsMultipartFile file : fileList) {
            //判断该文件是否为空
            if (!file.isEmpty()){
                //防止文件名重复uuid_name.jpg
                String prefix = UUID.randomUUID().toString();
                //去掉前缀中的中划线
                prefix = prefix.replace("-","");
                //新文件名 = 前缀 + "_" + 文件名
                String fileName = prefix + "_" + file.getOriginalFilename();
                //实例化文件对象
                File file2 = new File(realPath + File.separator + fileName);
                //上传文件
                file.transferTo(file2);
            }
        }
        //return "success";
        return "redirect:/file/showFile.action";
    }

    //文件列表显示
    @RequestMapping("/showFile")
    public String showFile(HttpServletRequest request, Model model) throws Exception{
        //获取ServletContext对象
        ServletContext servletContext = request.getServletContext();
        //获取文件的真实路径
        String path = servletContext.getRealPath("/upload");
        //获取上传的所有文件
        File[] fileList = new File(path).listFiles();
        //保存数据
        model.addAttribute("fileList",fileList);
        return "showFile";
    }

    //下载文件
    @RequestMapping("/fileDownload")
    public ResponseEntity<byte[]> fileDownload(HttpServletRequest request,
                                               @RequestParam(value = "path") String path) throws Exception{
        //定义字节数组
        byte[] bys = null;
        //c3449ae7315746b1a4ed9f0d95ed7e42_stuinfo.sql,即截取文件名
        String fileName = path.substring(path.lastIndexOf("_") + 1);
        //实例化文件对象
        File file = new File(path);
        //实例化字节输入流
        InputStream in = new FileInputStream(file);
        //获取上传的文件字节数
        bys = new byte[in.available()];
        //读取字节数组
        in.read(bys);
        //实例化HttpHeaders对象
        HttpHeaders headers = new HttpHeaders();
        //设置报头并拼接文件名
        headers.add("Content-Disposition","attachment;filename=" + fileName);
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //实例化返回内容
        ResponseEntity<byte[]> response = new ResponseEntity<>(bys,headers,statusCode);
        //关闭资源
        in.close();
        return response;
    }
}
