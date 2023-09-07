package com.library.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private Integer bookId;

    @NotEmpty
    @Size(min = 4,message = "Book Name must be 4 Character ")
    private String bookName;
    @NotEmpty
    @Size(min = 10,message = "Book Details must be 10 Character ")
    private String bookDetails;

    private GenresDto genresDto;

}
