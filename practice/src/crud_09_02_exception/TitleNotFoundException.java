package crud_09_02_exception;

public class TitleNotFoundException extends Exception {

	private String title;
	
	public TitleNotFoundException(String title) {
		super(title + "없어요");
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	
}
