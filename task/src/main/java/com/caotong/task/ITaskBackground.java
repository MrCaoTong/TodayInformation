package com.caotong.task;

public interface ITaskBackground<Result> {
    Result onBackground();
}
