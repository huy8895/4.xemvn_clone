package com.xem_vn.repository;

import com.xem_vn.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ILoveCommentRepository extends CrudRepository<LoveComment,Long> {
    Iterable<LoveComment> findAllByComment(Comment comment);
    Iterable<LoveComment> findAllByAppUser(AppUser user);
    boolean existsByAppUserAndComment(AppUser appUser, Comment comment);
    Long countAllByComment (Comment comment);
    LoveComment getByAppUserAndComment (AppUser user,Comment comment);
    boolean existsByAppUserId(Long appUserId);

    @Query(value = "select app_user_id from lovescomment",nativeQuery = true)
    List<Long> getListUserIds();
}