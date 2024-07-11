package com.och.esl.service;


import com.och.esl.FsEslMsg;

/**
 * @author danmo
 * @date 2023-10-20 10:46
 **/
public interface IFsEslEventService {

    public void eslEventPublisher(FsEslMsg lfsEslMsg);

    void destroyThreadPool();
}
