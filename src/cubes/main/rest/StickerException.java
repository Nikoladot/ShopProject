package cubes.main.rest;

public class StickerException extends RuntimeException {

	public StickerException() {
		
		super("Doslo je do problema sa ucitavanjem stikera");
}

public StickerException(String message) {

		super(message);
	
}
	
	
}
