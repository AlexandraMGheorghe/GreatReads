Great Reads App
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
The purpose of Great Reads is to provide users with various features to organize and keep track of the books they read, as well as share their opinions and reviews. Additionally, authors have the opportunity to publish their books in electronic format and receive feedback from readers.

Users can have different roles, such as Administrator, Author, or Reader. 
An Administrator can approve or reject book publications and user comments. 
An Author can publish multiple books, and a book can have multiple authors. To represent this many-to-many relationship between Author and Book, an additional join table named authors_to_books is needed. 
A Reader can mark a book as read, which will add the book to their list of read books. The Reader can also add books to their wishlist, creating another many-to-many relationship that requires an additional join table named readers_to_wishlist. Additionally, a Reader can publish a Review, which is a one-to-many relationship that only requires the Review entity.
 
![image](https://user-images.githubusercontent.com/77536806/233862940-10d40852-ba8c-4c6f-a02c-683792a14129.png)
