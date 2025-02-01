/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author awadallah
 */
public class Book {

    private String title, author, isbn, publishDate, pageCount, copyCount, publisher, bookImagePath, catgeory, language;
    private int id;

    public Book(String title, String author, String isbn, String publishDate, String pageCount,
            String copyCount, String publisher, String bookImagePath, String catgeory, String language) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishDate = publishDate;
        this.pageCount = pageCount;
        this.copyCount = copyCount;
        this.publisher = publisher;
        this.bookImagePath = bookImagePath;
        this.catgeory = catgeory;
        this.language = language;
    }

    public Book(int id, String title, String author, String isbn, String publishDate, String pageCount,
            String copyCount, String publisher, String bookImagePath, String catgeory, String language) {
      
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishDate = publishDate;
        this.pageCount = pageCount;
        this.copyCount = copyCount;
        this.publisher = publisher;
        this.bookImagePath = bookImagePath;
        this.catgeory = catgeory;
        this.language = language;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the ISBN
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the ISbN to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the publishDate
     */
    public String getPublishDate() {
        return publishDate;
    }

    /**
     * @param publishDate the publishDate to set
     */
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * @return the pageCount
     */
    public String getPageCount() {
        return pageCount;
    }

    /**
     * @param pageCount the pageCount to set
     */
    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * @return the copyCount
     */
    public String getCopyCount() {
        return copyCount;
    }

    /**
     * @param copyCount the copyCount to set
     */
    public void setCopyCount(String copyCount) {
        this.copyCount = copyCount;
    }

    /**
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @return the profileImagePath
     */
    public String getBookImagePath() {
        return bookImagePath;
    }

    /**
     * @param profileImagePath the profileImagePath to set
     */
    public void setBookImagePath(String profileImagePath) {
        this.bookImagePath = profileImagePath;
    }

    /**
     * @return the category
     */
    public String getCatgeory() {
        return catgeory;
    }

    /**
     * @param category the category to set
     */
    public void setCatgeory(String category) {
        this.catgeory = category;
    }

    /**
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

}
