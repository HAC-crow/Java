package test.dao.mybatisplusservice;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.dao.MenuMapper;
import test.domain.interfaces.MenuService;
import test.dtos.Menu;

import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List getmenu1() {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        List<Map<String, Object>> list = menuMapper.selectMaps(queryWrapper);
        return list;
    }
}
