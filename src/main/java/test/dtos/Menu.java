package test.dtos;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("MENULIST")
public class Menu {
    private int ID;
    private String SUBMENU;
    private int  PID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSUBMENU() {
        return SUBMENU;
    }

    public void setSUBMENU(String SUBMENU) {
        this.SUBMENU = SUBMENU;
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public String getMENU() {
        return MENU;
    }

    public void setMENU(String MENU) {
        this.MENU = MENU;
    }

    private String MENU;
}
