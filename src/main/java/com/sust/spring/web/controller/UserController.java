package com.sust.spring.web.controller;

import com.sust.spring.domain.User;
import com.sust.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Date;

@Controller
@RequestMapping(path = "/users")
public class UserController {

    private static final String PROFILE_IMAGE_SAVE_LOCATION = "/tmp/servlet-uploads";

    @Autowired
    private UserService userService;

    //查询全部的用户信息
    @RequestMapping(method = RequestMethod.GET)
    public String findAllUsers(Model model){
        model.addAttribute("users",userService.findAllUsers());
        return "user/list";
    }

    //根据id获取用户信息
    @RequestMapping(path = "/{id}")
    public ModelAndView viewUser(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("user/view");
        modelAndView.addObject("user",userService.findById(id));
        return modelAndView;
    }

    //新增准备
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newUserForm(Model model) {
        User user = new User();
        user.setDateOfBirth(new Date());
        model.addAttribute("user", user);
        return "user/new";
    }

    //新增执行
    @RequestMapping(path = "new",method = RequestMethod.POST)
    public String saveNewUser(@ModelAttribute("user") User user){
        boolean flag = userService.createNewUser(user);
        return "redirect:/users";
    }

    //修改准备
    @RequestMapping(path = "/{id}/edit",method = RequestMethod.GET)
    public String editUser(@PathVariable("id") Long id,Model model){
        model.addAttribute("user",userService.findById(id));
        return "user/edit";
    }

    //修改执行
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") User user) {
        user.setId(id);
        boolean flag = userService.updateUser(user);
        //System.out.print(user);
        return "redirect:/users/" + id;
    }

    //展示上传页面
    @RequestMapping(path = "/{id}/profileForm", method = RequestMethod.GET)
    public String uploadProfileImage(@PathVariable("id") Long userId, Model model){
        model.addAttribute("user",userService.findById(userId));
        return "user/upload";
    }

    //处理上传信息
    @RequestMapping(path = "/{id}/profileForm", method = RequestMethod.POST)
    public String uploadProfileImage(@PathVariable("id") Long userId, @RequestParam("profileImage") MultipartFile file) throws IOException {
        User user = userService.findById(userId);
        //创建文件路径///tmp/servlet-uploads/1/xxx.png
        String fileSaveDirectory = PROFILE_IMAGE_SAVE_LOCATION + "/" + user.getId();
        //判断上传是否为空
        if (!file.isEmpty()){
            //创建路径
            java.io.File fileDir = new File(fileSaveDirectory);
            if (!fileDir.exists()){
                fileDir.mkdirs();//创建文件夹
            }
            //拷贝文件放入服务器中
            FileCopyUtils.copy(file.getBytes(), new java.io.File(fileSaveDirectory + "/" + file.getOriginalFilename()));

            System.out.print(new java.io.File(fileDir.getPath() + "/" + file.getOriginalFilename()).getAbsolutePath());
            //将上传信息保存到数据库中
            //this.userService.addProfileImage(userId, file.getOriginalFilename());
        }
        return "redirect:/users/" + userId;
    }

    //显示图片
    @RequestMapping(path = "/{userId}/profileImage", method = RequestMethod.GET)
    public void downloadProfileImage(@PathVariable("id") Long id, HttpServletResponse response) throws IOException{
        //查询用户信息并带图片
        User user = userService.findWithFileById(id);
        System.out.println(user);
        //判断图片信息是否为空
        if (user.getProfileImage() != null){
            //保存路径
            String fileSaveDirectory = PROFILE_IMAGE_SAVE_LOCATION  + "/" + user.getId();
            //物理路径
            java.io.File physicalFile = new java.io.File(fileSaveDirectory + "/" + user.getProfileImage().getFileName());
            //如果图片存在
            if (physicalFile.exists()){
                //根据文件的名称猜测文件的类型
                String mimeType = URLConnection.guessContentTypeFromName(physicalFile.getName());
                //设置响应头---表示后面的文档属于什么MIME类型
                response.setContentType(mimeType);
                System.out.println(String.format("inline: filename=\"" + physicalFile.getName() + "\"") + "--------");
                //设置响应头
                //Content-Disposition 属性是作为对下载文件的一个标识字段
                //inline 和 attachment  inline ：将文件内容直接显示在页面
                response.setHeader("Content-Disposition",
                        String.format("inline; filename=\"" + physicalFile.getName() + "\""));
                //设置响应头 --- 表示内容长度
                response.setContentLength((int) physicalFile.length());
                //设置文件输入流
                InputStream inputStream = new BufferedInputStream(new FileInputStream(physicalFile));
                //将输入流的信息copy到输出流中
                FileCopyUtils.copy(inputStream, response.getOutputStream());
                return;
            }
        }
        //错误文字提示信息
        String errorMessage = "Sorry. The file you are looking for does not exist";
        System.out.println(errorMessage);
        OutputStream outputStream = response.getOutputStream();
        //输出错误提示信息
        outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
        //关闭输出流
        outputStream.close();

    }

}
