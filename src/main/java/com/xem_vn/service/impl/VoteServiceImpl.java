package com.xem_vn.service.impl;

import com.xem_vn.model.AppUser;
import com.xem_vn.model.Like;
import com.xem_vn.model.Post;
import com.xem_vn.model.Vote;
import com.xem_vn.repository.IVoteRepository;
import com.xem_vn.service.IVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements IVoteService {
    @Autowired
    private IVoteRepository voteRepository;

    @Override
    public Iterable<Vote> findAllByPost(Post post) {
        return voteRepository.findAllByPost(post);
    }

    @Override
    public Iterable<Vote> findAllByUser(AppUser user) {
        return voteRepository.findAllByAppUser(user);
    }

    @Override
    public void save(Vote vote) {
        voteRepository.save(vote);
    }

    @Override
    public void remove(Vote vote) {
        voteRepository.delete(vote);
    }

    @Override
    public boolean existsByAppUserAndAndPost(AppUser user, Post post) {
        return voteRepository.existsByAppUserAndAndPost(user, post);
    }

    @Override
    public Long sumOfValues(Post post) {
        return voteRepository.sumOfValues(post.getId());
    }

    @Override
    public Vote getByAppUserAndAndPost(AppUser user, Post post) {
        return voteRepository.getByAppUserAndAndPost(user, post);
    }
}
