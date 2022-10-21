package com.ssafy.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	@NonNull
    private String isbn;
	@NonNull
    private String title;
	@NonNull
    private String author;
	@NonNull
    private int price;
    private String description;
    private String img;
    private FileInfo fileInfo;
    
}
