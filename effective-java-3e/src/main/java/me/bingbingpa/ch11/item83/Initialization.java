package me.bingbingpa.ch11.item83;

public class Initialization {

    private final FieldType field1 = computeFieldValue();

    private FieldType field2;
    private synchronized FieldType getField2() {
        if (field2 == null){
            field2 = computeFieldValue();
        }
        return field2;
    }

    private static class FieldHolder {
        static final FieldType field = computeFieldValue();
    }

    private static FieldType getField() {
        return FieldHolder.field;
    }


    private volatile FieldType field4;

    private FieldType getField4() {
        FieldType result = field4;
        if (result != null) { // 첫 번째 검사 (락 사용 안 함)
            return result;
        }

        synchronized(this) {
            if (field4 == null) { // 두 번째 검사 (락 사용)
                field4 = computeFieldValue();
            }
            return field4;
        }
    }

    private volatile FieldType field5;

    private FieldType getField5() {
        FieldType result = field5;
        if (result == null) {
            field5 = result = computeFieldValue();
        }
        return result;
    }

    private static FieldType computeFieldValue() {
        return new FieldType();
    }
}
