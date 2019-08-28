package test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import test.dao.mybatisplusservice.MyBatisPlusContactMaintainService;
import test.domain.models.Contact;
import test.domain.models.LimitPage;
import test.dtos.Contacts;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/iContactMaintainController")
public class IContactMaintainController {
    @Autowired
    private MyBatisPlusContactMaintainService myBatisPlusContactMaintainService;


    @PostMapping("/create")
    @ResponseBody
    public boolean create(@RequestParam("file") MultipartFile file, Contact contact) throws IOException {
        if(file.isEmpty()){
            System.out.println("file为空");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String res = sdf.format(new Date());
        String originaFilename = file.getOriginalFilename();
        String newFileName = res+originaFilename.substring(originaFilename.lastIndexOf("."));
        String rootPath = "/images/";
        File newFile = new File(rootPath+newFileName);
        System.out.println(rootPath+newFileName);
        String src=rootPath+newFileName;
        contact.setPhotoUrl(src);
        if(!newFile.getParentFile().exists()){
            newFile.getParentFile().mkdirs();
        }else{
            System.out.println(newFile.getParentFile());
        }
        if(!newFile.exists()){
            file.transferTo(newFile);
        }
        System.out.println(contact.isSex());
        return myBatisPlusContactMaintainService.create(contact);
    }
    @PostMapping("/delete")
    @ResponseBody
    public boolean delete(@RequestBody int idnumber){
        return myBatisPlusContactMaintainService.delete(idnumber);
    }
    @PostMapping("/get")
    @ResponseBody
    public Contact get(@RequestBody int idnumber) throws ParseException {
        return myBatisPlusContactMaintainService.get(idnumber);
    }
    @PostMapping("/update")
    @ResponseBody
    public boolean update(@RequestParam("file") MultipartFile file, Contact contact) throws IOException{
        if(file.isEmpty()){
            System.out.println("file为空");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String res = sdf.format(new Date());
        String originaFilename = file.getOriginalFilename();
        String newFileName = res+originaFilename.substring(originaFilename.lastIndexOf("."));
        String rootPath = "/images/";
        File newFile = new File(rootPath+newFileName);
        System.out.println(rootPath+newFileName);
        String src=rootPath+newFileName;
        contact.setPhotoUrl(src);
        if(!newFile.getParentFile().exists()){
            newFile.getParentFile().mkdirs();
        }else{
            System.out.println(newFile.getParentFile());
        }
        if(!newFile.exists()){
            file.transferTo(newFile);
        }
        return myBatisPlusContactMaintainService.update(contact);
    }
    @PostMapping("/updatenotfile")
    @ResponseBody
    public boolean updatenotfile(Contacts contacts){
    	Contact contact = new Contact();
    	contact.setIdNumber(contacts.getIdNumber());
    	contact.setName(contacts.getName());
    	contact.setSex(contacts.isSex());
    	contact.setBirthday(contacts.getBirthday());
    	contact.setPhone(contacts.getPhone());
    	contact.setAddress(contacts.getAddress());
    	contact.setPhotoUrl(contact.getPhotoUrl());
        return myBatisPlusContactMaintainService.updatenotfile(contact);
    }
    @RequestMapping("/getcount")
    @ResponseBody
    public List getcount(@RequestBody double bars){
        return myBatisPlusContactMaintainService.getcount(bars);
    }
    /**
     * 获取列表数据(已分页)
     * @return
     */
    @PostMapping("/getList")
    @ResponseBody
    public List<Contact> getList(@RequestBody LimitPage limitPage)throws ParseException{
        int limit=limitPage.getBars();
        int page=limitPage.getValue();
        System.out.println("给点反应啊倒是");
        return myBatisPlusContactMaintainService.getList(limit,page);
    };
}
