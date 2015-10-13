package com.bruyako.impl;

import com.bruyako.dao.PostDao;
import com.bruyako.model.Contact;
import com.bruyako.model.Post;
import javafx.geometry.Pos;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by brunyatko on 21.09.15.
 */
@Repository
public class PostDaoImpl implements PostDao {

    private static long id = 1;
    private Map<Long, Post> postsMap = new HashMap<>();

    @Override
    public Set<Contact> getAllPostsForContact(Post post) {
        return post.getPostsOfContact();
    }

    @Override
    public void create(Post post) {
        post.setId(id++);
        postsMap.put(post.getId(), post);
    }

    @Override
    public void delete(Post post) {

        Long tmp = null;

        for (Map.Entry entry : postsMap.entrySet()) {
            if (entry.getValue().equals(post)) {
                tmp = (Long) entry.getKey();
                break;
            }
        }
        postsMap.remove(tmp);

    }

    @Override
    public List<Post> getAll() {

        List<Post> allPosts = new ArrayList<>();

        for (Map.Entry entry : postsMap.entrySet()) {
            allPosts.add((Post) entry.getValue());
        }

        return allPosts;
    }

    @Override
    public Post getById(Long id) {

        Post postById = null;

        for (Map.Entry entry : postsMap.entrySet()) {
            if (entry.getKey().equals(id)) {
                postById = (Post) entry.getValue();
            }
        }

        return postById;
    }

}
