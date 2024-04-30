package dev.sriharsha.bookstore.backend.mapper;

import dev.sriharsha.bookstore.backend.dto.BookRequest;
import dev.sriharsha.bookstore.backend.dto.BookResponse;
import dev.sriharsha.bookstore.backend.dto.BorrowedBookResponse;
import dev.sriharsha.bookstore.backend.entity.Book;
import dev.sriharsha.bookstore.backend.entity.TransactionHistory;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public Book mapToBook(BookRequest request) {
        return Book.builder()
                .id(request.id())
                .title(request.title())
                .bookCover(request.bookCover())
                .shareable(request.shareable())
                .author(request.author())
                .archived(false)
                .synopsis(request.synopsis())
                .build();
    }

    public BookResponse mapToBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .bookCover(book.getBookCover())
                .shareable(book.isShareable())
                .author(book.getAuthor())
                .archived(book.isArchived())
                .synopsis(book.getSynopsis())
                .rating(book.getRating())
                .userId(book.getOwner().getId())
                .username(book.getOwner().getFullname())
                .build();
    }

    public BorrowedBookResponse mapToBorrowedBookResponse(TransactionHistory transactionHistory) {
        return BorrowedBookResponse.builder()
                .id(transactionHistory.getBook().getId())
                .title(transactionHistory.getBook().getTitle())
                .author(transactionHistory.getBook().getAuthor())
                .rating(transactionHistory.getBook().getRating())
                .returned(transactionHistory.getReturned())
                .returnApproved(transactionHistory.getReturnApproved())
                .build();
    }

}
