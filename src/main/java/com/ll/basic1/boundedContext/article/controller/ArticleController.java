package com.ll.basic1.boundedContext.article.controller;

import com.ll.basic1.base.rsData.RsData;
import com.ll.basic1.boundedContext.article.entity.Article;
import com.ll.basic1.boundedContext.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor //필드 중에서 final 붙은것만 인자로 입력받는 생성자 생성
public class ArticleController {
    private final ArticleRepository articleRepository;
    @GetMapping("/write")
    @ResponseBody
    public RsData write(String title, String content) {
        Article article = Article
                .builder()
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .title(title)
                .content(content)
                .build();

        articleRepository.save(article); // INSERT, or UPDATE

        return RsData.of("S-1", "1번 글이 생성되었습니다.",article);

    }
}
