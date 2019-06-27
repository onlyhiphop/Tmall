package cn.hm.controller;

import cn.hm.common.utils.FastDFSClient;
import cn.hm.common.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lbc
 * @description: 图片上传
 * @date 2019/6/26 10:12
 */
@Controller
public class PictureController {

    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;

    @RequestMapping(value = "/pic/upload", produces = MediaType.TEXT_PLAIN_VALUE + ";charset=utf-8")  //设置响应的编码格式
    @ResponseBody
    public String uploadFile(MultipartFile uploadFile){ //参数名字必须和前端对应，才能自动装配
        try {
            //把图片上传到图片服务器中
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/client.conf");
            //取文件的扩展名
            String fileName = uploadFile.getOriginalFilename();
            String extName = fileName.substring(fileName.lastIndexOf(".") + 1);
            //得到一个图片的地址和文件名   /group1/M00/00/00/xxx.jpg
            String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
            //补充为完整的url
            url = IMAGE_SERVER_URL + url;   // http://192.168.2.20/group1/M00/00/00/xxx.jpg
            //封装到map中返回
            Map map = new HashMap();
            map.put("error", 0);
            map.put("url", url);
            //返回字符串，就不需要@ResponseBody包装了，response头信息就会为 text/plain,解决浏览器兼容性
            return JsonUtils.objectToJson(map);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}




































