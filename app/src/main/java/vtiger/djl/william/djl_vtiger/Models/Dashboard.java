package vtiger.djl.william.djl_vtiger.Models;

/**
 * Created by William on 21/03/2018.
 */

public class Dashboard {
    private int number;
    private String item;
    private String icon;

    public Dashboard() {
    }

    public Dashboard(int number, String item, String icon) {
        this.number = number;
        this.item = item;
        this.icon = icon;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
