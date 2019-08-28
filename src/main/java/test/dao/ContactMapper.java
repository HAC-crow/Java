package test.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface ContactMapper {
    int create(@Param("name")String name, @Param("sex")Boolean sex, @Param("date") Date date, @Param("phonenum")String phonenum, @Param("local")String local, @Param("photo")String photo);
    int delete(@Param("idnumber") int idnumber);
    List get(@Param("idnumber") int idnumber);
    int update(@Param("name")String name, @Param("sex")Boolean sex, @Param("date") Date date, @Param("phonenum")String phonenum, @Param("local")String local, @Param("photo")String photo,@Param("id") String id);
    int updatenotfile(@Param("name")String name, @Param("sex")Boolean sex, @Param("date") Date date, @Param("phonenum")String phonenum, @Param("local")String local, @Param("id") String id);
    int getcount();
    List getList(@Param("limit")int limit, @Param("page")int page);
}
