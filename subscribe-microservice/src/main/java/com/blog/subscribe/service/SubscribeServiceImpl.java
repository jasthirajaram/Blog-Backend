package com.blog.subscribe.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.subscribe.dao.SubscribeDao;
import com.blog.subscribe.entity.Subscribe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SubscribeServiceImpl implements SubscribeService {

    @Autowired
    private SubscribeDao subscribeDao;
    @Override
    public List<Subscribe> getAllSubscribe() {
        log.info("getAll() -> | ");
        List<Subscribe> all = subscribeDao.getAllSubscribe();
        log.info("getAll() -> | List Subscribe : {}",all);
        return all;
    }

    @Override
    public Subscribe create(Subscribe subscribe) {
        log.info("create(Subscribe) -> | Subscribe : {}",subscribe);
        subscribe.setId(UUID.randomUUID().toString());
        log.info("create(Subscribe) -> | Set Id : {}",subscribe);
        Subscribe getSave = subscribeDao.create(subscribe);
        log.info("create(Subscribe) -> | After execute Dao Create : {}",getSave);
        return getSave;
    }

    @Override
    public String unSubscribe(String id) {
        log.info("unsubscribe() -> | Unsubscribing Subscribe : {}");
        subscribeDao.unSubscribe(id);
        log.info("unsubscribe() -> | Subscribe Unsubscribed : {}");
        return "Successfully unsubscribed";
    }

    @Override
    public Subscribe findSubscribeByEmail(String email) {
        log.info("findSubscribeByEmail() -> | ");
        Subscribe subscribe = subscribeDao.findSubscribeByEmail(email);
        log.info("findSubscribeByEmail() -> | Subscribe : {}", subscribe);
        return subscribe;
    }

    @Override
    public void subscribeDeleteById(String id) {
        log.info("subscribeDeleteById(String) -> | Id : {}",id);
        subscribeDao.subscribeDeleteById(id);
        log.info("subscribeDeleteById(String) -> | Id : {} | Deleted",id);
    }
    
    @Override
    public Subscribe findSubscribeById(String id) {
        log.info("findSubscribeById() -> | ");
        Subscribe subscribe = subscribeDao.findSubscribeById(id);
        log.info("findSubscribeById() -> | Subscribe : {}", subscribe);
        return subscribe;
    }
}