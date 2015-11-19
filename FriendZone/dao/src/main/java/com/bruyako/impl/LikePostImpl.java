package com.bruyako.impl;

import com.bruyako.LikePostInterface;
import com.bruyako.converters.EntityDtoConverter;
import com.bruyako.entity.LikePostDao;
import com.bruyako.model.LikePostDto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.bruyako.converters.EntityDtoConverter.convert;

/**
 * Created by brunyatko on 10.11.15.
 */
@Transactional
@Repository
public class LikePostImpl implements LikePostInterface {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveLikePost(LikePostDto likePostDto) {

        LikePostDao likePost = convert(likePostDto);
        sessionFactory.getCurrentSession().saveOrUpdate(likePost);
    }

    @Override
    public int getCountLike(Long postId) {

        List<LikePostDao> likePostList = sessionFactory.getCurrentSession().createSQLQuery("select * from LikePost join Post on LikePost.Post_id = Post.Post_id " +
                "where Post.Post_id = :id").addEntity(LikePostDao.class).setParameter("id", postId).list();
        List<LikePostDto> result = new ArrayList<>(likePostList.size());

        for (LikePostDao likePost : likePostList){
            result.add(EntityDtoConverter.convert(likePost));
        }

        return result.size();
    }

    @Override
    public boolean isLike(Long postId, Long contactId) {
        return false;
    }

}