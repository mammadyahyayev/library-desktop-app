package model;

public class OnlyOrder extends AbstractModel {

    private int num;
    private String tOrder;
    private Menu menu;
    private Float price;
    private String resName;

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String gettOrder() {
        return tOrder;
    }

    public void settOrder(String tOrder) {
        this.tOrder = tOrder;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

}
