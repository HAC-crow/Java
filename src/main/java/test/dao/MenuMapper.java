package test.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import test.dtos.Menu;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

}
