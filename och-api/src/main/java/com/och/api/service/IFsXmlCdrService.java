package com.och.api.service;


import com.och.common.exception.ParserException;

public interface IFsXmlCdrService {
    void cdrHandler(String reqText) throws ParserException;
}
