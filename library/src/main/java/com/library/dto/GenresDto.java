package com.library.dto;

import jakarta.validation.constraints.NotBlank;
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
public class GenresDto {

    private Integer genresId;
    @NotEmpty
    @Size(min = 4,message = "Genres Name must be 4 Character ")
    private String genresName;
    @NotEmpty
    @Size(min = 10,message = "description must be minimum 10 character")
    private String description;
}
