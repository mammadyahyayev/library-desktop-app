package enums;

public class Enums {

    public enum StudentEnum {

        VIEW(7),
        SEND_MESSAGE(8),
        EDIT(9),
        DELETE(10);

        private final int value;

        private StudentEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    public enum BookEnum {
        VIEW(9),
        EDIT(10),
        DELETE(11),
        ORDER_BOOK(12);

        private final int value;

        private BookEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    public enum MenuEnum {
        VIEW(4),
        EDIT(5),
        DELETE(6);

        private final int value;

        private MenuEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    public enum EnumSixToEight {
        VIEW(6),
        EDIT(7),
        DELETE(8);

        private final int value;

        private EnumSixToEight(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    public enum EmployeeEnum {
        VIEW(9),
        EDIT(10),
        DELETE(11);

        private final int value;

        private EmployeeEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

}
