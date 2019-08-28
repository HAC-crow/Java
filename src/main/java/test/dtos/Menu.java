package test.dtos;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("menu1")
public class Menu {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;
}
