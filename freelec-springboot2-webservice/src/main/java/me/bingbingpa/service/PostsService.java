package me.bingbingpa.service;

import lombok.RequiredArgsConstructor;
import me.bingbingpa.domain.posts.Posts;
import me.bingbingpa.domain.posts.PostsRepository;
import me.bingbingpa.web.dto.PostResponseDto;
import me.bingbingpa.web.dto.PostSaveRequestDto;
import me.bingbingpa.web.dto.PostUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해달 게시글이 없습니다. id=" + id));

        return new PostResponseDto(entity);
    }
}
