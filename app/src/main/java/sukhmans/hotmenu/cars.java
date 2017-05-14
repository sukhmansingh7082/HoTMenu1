package sukhmans.hotmenu;

public class cars {
public cars(String make, int year, int iconid, String condition) {
		super();
		this.make = make;
		this.year = year;
		this.iconid = iconid;
		this.condition = condition;
	}
private String make;
private int year;
private int iconid;
private String condition;
/**
 * @return the make
 */
public String getMake() {
	return make;
}
/**
 * @return the year
 */
public int getYear() {
	return year;
}
/**
 * @return the iconid
 */
public int getIconid() {
	return iconid;
}
/**
 * @return the condition
 */
public String getCondition() {
	return condition;
}

}
