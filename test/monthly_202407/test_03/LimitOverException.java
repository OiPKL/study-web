package test_03;

public class LimitOverException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final int MAX_SIZE = 20;
	private int size;
	
	public LimitOverException() {
		// this.size = super.size();
	}

}
