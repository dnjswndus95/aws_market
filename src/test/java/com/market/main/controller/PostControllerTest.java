package com.market.main.controller;

import com.market.main.entity.posts.Post;
import com.market.main.entity.posts.PostRequestDto;
import com.market.main.repository.PostRepository;
import com.market.main.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

   /* @AfterAll
    public void clear() throws Exception{
        postRepository.deleteAll();
    }
*/
    @Test
    public void 게시물_등록() throws Exception{
        String title = "title";
        String content = "내용";

        PostRequestDto postRequestDto = PostRequestDto.builder().title(title)
                .content(content)
                .build();

        String url = "http://localhost:" + port + "/post/new";
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, postRequestDto, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(content);

        List<Post> posts = postService.findAllPost();
        assertThat(posts.get(0).getTitle()).isEqualTo(title);
        assertThat(posts.get(0).getContent()).isEqualTo(content);
    }
}