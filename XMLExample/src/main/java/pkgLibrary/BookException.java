package pkgLibrary;

public class BookException extends Exception{
	
	private Catalog c;
	private String id;
	private Book b;
	
	public BookException(Catalog c, String id){
		super();
		this.id = id;
		this.c = c;
	}
	
	public BookException(Book b){
		super();
		this.b = b;
		
	}
	
	public Catalog getCat() {
		return c;
	}
	
	public String getId(){
		return id;
	}
	
	public Book getBook() {
		return b;
	}

}
