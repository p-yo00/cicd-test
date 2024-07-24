package com.example.awsspring;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class HelloController {

    private final PostRepository postRepository;

    @PostMapping("/post")
    public void savePost() {
        postRepository.save(Post.builder()
            .title("제목")
            .content("내용")
            .build());
    }

    @GetMapping("/post")
    public ResponseEntity<Post> getPost() {
        return ResponseEntity.ok(postRepository.findAll().get(0));
    }

    @GetMapping
    public String test() {
        return "Hello!!! CI/CD Test.";
    }
}
