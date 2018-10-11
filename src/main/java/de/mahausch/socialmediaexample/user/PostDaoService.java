package de.mahausch.socialmediaexample.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service public class PostDaoService {

    @Autowired private PostRepository postRepository;

    Post save(Post post) {
        return postRepository.save(post);
    }
}
