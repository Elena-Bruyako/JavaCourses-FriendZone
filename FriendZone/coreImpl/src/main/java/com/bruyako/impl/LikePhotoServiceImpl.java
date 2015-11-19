package com.bruyako.impl;

import com.bruyako.LikePhotoInterface;
import com.bruyako.LikePhotoService;
import com.bruyako.model.LikePhotoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by brunyatko on 10.11.15.
 */
@Transactional
@Service
public class LikePhotoServiceImpl implements LikePhotoService {

    @Autowired
    private LikePhotoInterface likePhotoDao;

    @Override
    public void saveLikePhoto(LikePhotoDto likePhotoDto) {
        likePhotoDao.saveLikePhoto(likePhotoDto);
    }

    @Override
    public int getCountLikePhoto(Long photoId) {
        return likePhotoDao.getCountLike(photoId);
    }

    @Override
    public boolean isLikePhoto(Long id, Long contactId) {
        return likePhotoDao.isLike(id, contactId);
    }
}
