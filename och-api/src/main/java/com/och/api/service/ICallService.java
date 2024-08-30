package com.och.api.service;


import com.och.system.domain.query.call.CallQuery;

public interface ICallService {

    Long makeCall(CallQuery query);
}
