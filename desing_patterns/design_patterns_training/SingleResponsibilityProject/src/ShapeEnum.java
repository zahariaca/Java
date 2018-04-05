
public enum ShapeEnum {
	DREPTUNGHI(1), 
	PATRAT(2),
	TRIUNGHI(3);
	
	private int code;
	
	ShapeEnum(int code){
		this.code = code;
	}
	public int getValue() {
		return this.code;
	}
}
