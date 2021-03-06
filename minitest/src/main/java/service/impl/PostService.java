package service.impl;

import model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repository.PostRepository;
import service.IPostService;

import java.util.List;
import java.util.Optional;

public class PostService implements IPostService {
    @Autowired
    PostRepository postRepository;




    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }


    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void remove(Long id) {
        postRepository.deleteById(id);
    }

    public List<Post> findByTitle(String title){
        return postRepository.findAllByTitleContaining(title);
    }

    public Iterable<Post> showListPostAsc() {
        return postRepository.findAllByLikesAsc();
    }

    public Iterable<Post> showTop4New() {
        return postRepository.findTop4New();
    }

    public Page<Post> orderByCreatAt(Pageable pageable){
        return postRepository.findAllByOrderByCreateAt(pageable);
    }
}
