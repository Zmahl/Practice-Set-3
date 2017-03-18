package pkgLibrary;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Catalog {

	@XmlAttribute
	int id;	
	
	@XmlElement(name="book")
	ArrayList<Book> books;
	
	
	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	
	public static Book GetBook(String id)throws BookException{
		try{
			
			Catalog c = ReadXMLFile();
			for (Book b : c.getBooks()){
				if (b.getId() == id){
					return b;
				}
			}
			System.out.println("CategoryID " + c.getId());
			System.out.println("Book count: " + c.getBooks().size());
			throw new BookException(c, id);

		} catch (BookException bkE) {
			throw bkE;
		} catch (Exception e) {
			throw e;
		}
	}
	
	private static Catalog ReadXMLFile() {

		Catalog cat = null;

		String basePath = new File("").getAbsolutePath();
		basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
		File file = new File(basePath);

		System.out.println(file.getAbsolutePath());
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			cat = (Catalog) jaxbUnmarshaller.unmarshal(file);
			System.out.println(cat);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return cat;

	}
	
	public void AddBook (String id, Book book) {
		try {
			Catalog cat =ReadXMLFile();
			for (Book bk : books){
				if (bk.getId() == book.getId());
					throw new BookException(book.getId());
			
			}
			this.getBooks().add(book);
			WriteXMLFile();
	
	}
	catch (BookExpection be){
		System.out.println("Book " + id + "is already in the catalog. ");
	}
	}
}