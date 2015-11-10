package com.bruyako.impl;

import com.bruyako.LikePhotoDao;
import com.bruyako.entity.LikePhoto;
import com.bruyako.model.LikePhotoDto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static com.bruyako.converters.EntityDtoConverter.convert;

/**
 * Created by brunyatko on 10.11.15.
 */
@Transactional
@Repository
public class LikePhotoDaoImpl implements LikePhotoDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveLikePhoto(LikePhotoDto likePhotoDto) {

        LikePhoto likePhoto = convert(likePhotoDto);
        sessionFactory.getCurrentSession().saveOrUpdate(likePhoto);
    }

    @Override
    public int getCountLike(Long likePhotoId) {
        return 0;
    }

    @Override
    public boolean isLike(Long photoId, Long contactId) {
        return false;
    }
}
