package com.caotong.task;

public interface ITaskCallback<Result> {
    void onComplete(Result o);

    void onException(Throwable throwable);
}
