package com.forever.core;

import java.util.function.Supplier;

/**
 * 响应结果生成工具
 *
 * @author liuhq
 */
public class ResultGenerator {

    private static final String DEFAULT_SUCCESS_MESSAGE = "true";

    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static Result genSuccessResult(Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static Result genSuccessResult(Supplier<?> supplier) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(supplier.get());
    }

    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }

    public static Result genFailResult(Supplier<?> msgSupplier) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(msgSupplier.get().toString());
    }

    public static Result genExceptionResult(String message) {
        return new Result()
                .setCode(ResultCode.INTERNAL_SERVER_ERROR)
                .setMessage(message);
    }

    public static Result genExceptionResult(Supplier<?> msgSupplier) {
        return new Result()
                .setCode(ResultCode.INTERNAL_SERVER_ERROR)
                .setMessage(msgSupplier.get().toString());
    }
}
