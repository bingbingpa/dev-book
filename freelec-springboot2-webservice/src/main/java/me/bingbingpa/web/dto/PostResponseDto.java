package me.bingbingpa.web.dto;

import lombok.Getter;
import me.bingbingpa.domain.posts.Posts;

@Getter
public class PostResponseDto {

    private final Long id;
    private final String title;
    private final String content;
    private final String author;

    public PostResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
