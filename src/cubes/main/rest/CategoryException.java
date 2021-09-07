package cubes.main.rest;

public class CategoryException extends RuntimeException {
	
	
	public CategoryException() {
		
			super("Doslo je do problema sa ucitavanjem kategorije");
	}
	
	public CategoryException(String message) {
	
			super(message);
		
	}
	

}
