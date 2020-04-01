package com.caotong.http.result;

/**
 * 所有 IResponse 解析后的结果
 */
public interface IResult<T> {
    boolean isSuccess();

    int getCode();

    T data();
}
