package model;

public class TableOrder extends AbstractModel {

    private Table table;
    private OnlyOrder order;
    private String resName;

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public OnlyOrder getOrder() {
        return order;
    }

    public void setOrder(OnlyOrder order) {
        this.order = order;
    }

}
