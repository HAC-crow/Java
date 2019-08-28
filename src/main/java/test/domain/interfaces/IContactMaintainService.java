package test.domain.interfaces;

import test.domain.models.Contact;

import java.text.ParseException;
import java.util.List;

public interface IContactMaintainService {
    boolean create(Contact contact);
    boolean delete(int idNumber);
    Contact get(int idNumber) throws ParseException;
    boolean update(Contact contact);
    boolean updatenotfile(Contact contact);
    List getcount(double bars);
    List<Contact> getList(int limit,int page)throws ParseException ;
}
