package com.och.api.service;


import com.och.system.domain.query.login.LoginQuery;
import com.och.system.domain.vo.login.LoginUserVo;

/**
 * @author danmo
 * @date 2024-02-21 15:13
 **/
public interface ILoginService {
    LoginUserVo login(LoginQuery query);

    void logout();

}
