package org.pwr.transporter.entity.enums.documents;


import java.util.HashMap;
import java.util.Map;



/**
 * 
 * @author x0r
 * 
 */
public enum OrderType {

    SalesOrder("SALES_ORDER", "Zamówienie sprzedażowe", 0), TransportRequest("TRANSPORT_REQUEST", "Zamowienie kuriera", 1);

    private OrderType(String code, String name, int value) {
        this.code = code;
        this.name = name;
        this.value = value;
    }


    private String code;
    private String name;
    private int value;

    private static final Map<String, OrderType> nameMap = new HashMap<String, OrderType>();
    private static final Map<String, OrderType> codeMap = new HashMap<String, OrderType>();
    private static final Map<Integer, OrderType> valueMap = new HashMap<Integer, OrderType>();

    static {
        for( OrderType unit : OrderType.values() ) {
            nameMap.put(unit.name, unit);
            codeMap.put(unit.code, unit);
            valueMap.put(unit.value, unit);
        }
    }


    public String getCode() {
        return code;
    }


    public String getName() {
        return name;
    }


    public int getValue() {
        return value;
    }


    public static OrderType getUnitbyCode(String code) {
        return codeMap.get(code);
    }


    public static OrderType getUnitbyName(String name) {
        return nameMap.get(name);
    }


    public static OrderType getUnitbyValue(int value) {
        return valueMap.get(value);
    }
}
