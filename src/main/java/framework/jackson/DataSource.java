package framework.jackson;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DataSource {
    ACTIVITY("Activity"),
    STARFIX_FILE("Starfix file"),
    SPS_FILE("sps file");

    //display for UI
    String des;

    DataSource(String des) {
        this.des = des;
    }

    //for jackson
    public String getName() {
        return name();
    }

    //for gt tag
    public int getOrdinal() {
        return ordinal();
    }

    public String getDes() {
        return des;
    }
}
