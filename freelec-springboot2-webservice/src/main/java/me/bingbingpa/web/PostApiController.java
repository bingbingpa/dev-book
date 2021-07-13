package me.bingbingpa.web;

import lombok.RequiredArgsConstructor;
import me.bingbingpa.service.PostsService;
import me.bingbingpa.web.dto.PostResponseDto;
import me.bingbingpa.web.dto.PostSaveRequestDto;
import me.bingbingpa.web.dto.PostUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
