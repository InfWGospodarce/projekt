package org.pwr.transporter.entity.enums.base;


import java.util.HashMap;
import java.util.Map;


/**
 * 
 * @author x0r
 *
 */
public enum UnitDimension {

	Long("LONG", "Długość", 0), Weight("WEIGHT", "Waga", 1), Volume("VOLUME", "Objętość", 2), Density("DENSITY", "Gęstośćć", 3), Temp("TEMP",
			"Temperatura", 4), Energy("ENERGY", "Energia", 5), Area("AREA", "Powierzchnia", 6), Prefix("PREFIX", "Prefiks", 7), Time("TIME", "Czas",
			8), Other("OTHER", "Inne", 9);

	private UnitDimension( String code, String name, int value ) {
		this.code = code;
		this.name = name;
		this.value = value;
	}

	private String code;
	private String name;
	private int value;

	private static final Map<String, UnitDimension> nameMap = new HashMap<String, UnitDimension>();
	private static final Map<String, UnitDimension> codeMap = new HashMap<String, UnitDimension>();
	private static final Map<Integer, UnitDimension> valueMap = new HashMap<Integer, UnitDimension>();

	static {
		for( UnitDimension unit : UnitDimension.values() ) {
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

	public static UnitDimension getUnitbyCode( String code ) {
		return codeMap.get(code);
	}

	public static UnitDimension getUnitbyName( String name ) {
		return nameMap.get(name);
	}

	public static UnitDimension getUnitbyValue( int value ) {
		return valueMap.get(value);
	}
}
