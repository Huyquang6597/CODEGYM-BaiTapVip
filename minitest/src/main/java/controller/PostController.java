package controller;

import model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.IPostService;
import service.impl.PostService;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;


    @GetMapping
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("/post/list");
        modelAndView.addObject("posts", postService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/post/create");
        modelAndView.addObject("post", new Post());
        return modelAndView;
    }

    @PostMapping("/create")

    public ModelAndView save(Post post) {
        post.setCreateAt(LocalDateTime.now());
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("redirect:/posts");
        modelAndView.addObject("post", new Post());
        modelAndView.addObject("message", "Create successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/post/edit");
        Post post = postService.findById(id).get();
        modelAndView.addObject("po", post);

        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView update(@PathVariable Long id, Post post) {
        post.setCreateAt(LocalDateTime.now());
        ModelAndView modelAndView = new ModelAndView("redirect:/posts");
        postService.save(post);
        return modelAndView;
    }
    @GetMapping("/search")
    public ModelAndView showFindForm(@RequestParam String title) {
        ModelAndView modelAndView = new ModelAndView("/post/search");
        modelAndView.addObject("posts", postService.findByTitle(title));
        return modelAndView;
    }
    @PostMapping("/post-asc")
    public ModelAndView newPost() {
        Iterable<Post> posts = postService.showListPostAsc();
        ModelAndView modelAndView = new ModelAndView("/postListAsc");
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }

    @PostMapping("/post-top4-new")
    public ModelAndView newPostTop4() {
        Iterable<Post> posts = postService.showTop4New();
        ModelAndView modelAndView = new ModelAndView("/postTop4New");
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }

}
