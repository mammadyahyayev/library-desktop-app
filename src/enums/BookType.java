package enums;

public enum BookType {
    SOLD("sold"),
    BORROW("borrow"),
    READNOW("readNow");

    private String value;

    private BookType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
