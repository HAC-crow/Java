package test.dao.mybatisplusservice;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.dao.MenuMapper;
import test.domain.interfaces.MenuService;
import test.dtos.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List getmenu1() {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("pid","menu").groupBy("pid","menu");
        List<Map<String, Object>> list = menuMapper.selectMaps(queryWrapper);
        System.out.println(list);
        List<Map<String, Object>> list1 = new ArrayList<>();
        List<Map<String, Object>> list2 = new ArrayList<>();
        for(Map map:list){
            System.out.println(map.get("pid"));
            QueryWrapper<Menu> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.select("id","submenu").eq("pid",map.get("pid"));
            list1 = menuMapper.selectMaps(queryWrapper1);
            Map map1 = new HashMap();
            map1.put("value",list1);
            map1.put("name",map.get("menu"));
            list2.add(map1);
        }
        System.out.println(list2);
        return list2;
    }
}
