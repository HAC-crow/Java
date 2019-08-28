package test.dao.mybatisplusservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.dao.ContactMapper;
import test.domain.interfaces.IContactMaintainService;
import test.domain.models.Contact;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("myBatisPlusContactMaintainService")
public class MyBatisPlusContactMaintainService implements IContactMaintainService {

    @Autowired
    private ContactMapper contactMapper;

    @Override
    public boolean create(Contact contact) {
        String name=contact.getName();
        boolean sex=contact.isSex();
        Date date = contact.getBirthday();
        String phonenum = contact.getPhone();
        String local = contact.getAddress();
        String photo = contact.getPhotoUrl();
        int result = contactMapper.create(name,sex,date,phonenum,local,photo);
        if(result==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean delete(int idnumber) {
         int result = contactMapper.delete(idnumber);
        if(result==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Contact get(int idNumber) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        List contacts=contactMapper.get(idNumber);
        Map<String,Object> map =new HashMap();
        map=(Map<String,Object>)contacts.get(0);
        Contact contact=new Contact();
        contact.setIdNumber(map.get("id").toString());
        contact.setName(map.get("name").toString());
        contact.setSex(Boolean.parseBoolean(map.get("sex").toString()));
        contact.setBirthday(formatter.parse(map.get("date").toString()));
        contact.setPhone(map.get("phonenum").toString());
        contact.setAddress(map.get("local").toString());
        contact.setPhotoUrl(map.get("photo").toString());
        return contact;
    }

    @Override
    public boolean update(Contact contact){
        String id=contact.getIdNumber();
        String name=contact.getName();
        boolean sex=contact.isSex();
        Date date = contact.getBirthday();
        String phonenum = contact.getPhone();
        String local = contact.getAddress();
        String photo = contact.getPhotoUrl();
        int result = contactMapper.update(name,sex,date,phonenum,local,photo,id);
        if(result==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updatenotfile(Contact contact) {
        String id=contact.getIdNumber();
        String name=contact.getName();
        boolean sex=contact.isSex();
        Date date = contact.getBirthday();
        String phonenum = contact.getPhone();
        String local = contact.getAddress();
        int result = contactMapper.updatenotfile(name,sex,date,phonenum,local,id);
        if(result==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List getcount(double bars) {
        //先不添加任何查询条件，也不需要添加任何查询条件
        double count=contactMapper.getcount();
        double counts=Math.ceil(count/bars);
        List list=new ArrayList();
        for(int i=1;i<=counts;i++){
            list.add(i);
        }
        return list;
    }

    @Override
    public List<Contact> getList(int limit, int page) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        page=(page-1)*limit;
        List list=contactMapper.getList(limit,page);
        List<Contact> pro = new ArrayList<Contact>();
        for(int i=0;i<list.size();i++){
            Map<String,Object> map =new HashMap();
            map=(Map<String,Object>)list.get(i);
            Contact contact=new Contact();
            contact.setIdNumber(map.get("id").toString());
            contact.setName(map.get("name").toString());
            contact.setSex(Boolean.parseBoolean(map.get("sex").toString()));
            if(map.get("date")!=null){
                contact.setBirthday(formatter.parse(map.get("date").toString()));
            }
            if(map.get("phonenum")!=null){
                contact.setPhone(map.get("phonenum").toString());
            }
            if(map.get("local")!=null) {
                contact.setAddress(map.get("local").toString());
            }
            if(map.get("photo")!=null){
                contact.setPhotoUrl(map.get("photo").toString());
            }

            pro.add(contact);
        }
        return pro;
    }
}
