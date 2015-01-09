package org.pwr.transporter.entity.enums.article;


import java.util.HashMap;
import java.util.Map;



/**
 * <pre>
 *    Define article type
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public enum ArticleType {

    Article("ART", 0, "Artykuł"), Service("SERVICE", 1, "Usługa"), TransportService("TRANSPORT_SERVICE", 1, "Usługa transportowa");

    private static final Map<String, ArticleType> codeMap = new HashMap<String, ArticleType>();
    private static final Map<Integer, ArticleType> valueMap = new HashMap<Integer, ArticleType>();

    static {
        for( ArticleType art : ArticleType.values() ) {
            codeMap.put(art.code, art);
            valueMap.put(art.value, art);
        }
    }


    ArticleType(String code, int value, String name) {
        this.code = code;
        this.value = value;
        this.name = name;
    }


    private String code;
    private int value;
    private String name;


    public String getCode() {
        return this.code;
    }


    public String getName() {
        return this.name;
    }


    public int getValue() {
        return this.value;
    }


    public static ArticleType getByValue(int value) {
        return valueMap.get(value);
    }


    public static ArticleType getByCode(String code) {
        return codeMap.get(code);
    }

}
