package com.forezp.utils;


import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * 用于异步调度的工具类
 */
public final class AsyncUtil
{
    private static final ScheduledExecutorService SCHEDULER = Executors.newScheduledThreadPool(1,
            new ThreadFactoryBuilder().setDaemon(true).setNameFormat("failAfter-%d").build());

    private AsyncUtil()
    {
    }

    /**
     * <一句话功能简述> <功能详细描述>
     * 
     * @param duration
     * @return
     * 
     */
    private static <T> CompletableFuture<T> failAfter(Duration duration)
    {
        final CompletableFuture<T> promise = new CompletableFuture<>();
        SCHEDULER.schedule(() ->
        {
            final TimeoutException ex = new TimeoutException("Timeout after " + duration);
            return promise.completeExceptionally(ex);
        }, duration.toMillis(), TimeUnit.MILLISECONDS);
        return promise;
    }

    /**
     * 异步执行任务，并设置超时
     * 
     * @param future
     *            待执行的异步任务结果
     * @param duration
     *            超时时间
     * @param <T>
     *            <T>
     * @return CompletableFuture
     * 
     */
    public static <T> CompletableFuture<T> within(CompletableFuture<T> future, Duration duration)
    {
        final CompletableFuture<T> timeout = failAfter(duration);
        return future.applyToEither(timeout, Function.identity());
    }

    /**
     * 异步执行任务，并设置超时
     * 
     * @param supplier
     *            异步的labda表达式
     * @param duration
     *            超时时间
     * @param <T>
     *            <T>
     * @return CompletableFuture
     * 
     */
    public static <T> CompletableFuture<T> within(Supplier<T> supplier, Duration duration)
    {
        return within(CompletableFuture.supplyAsync(supplier), duration);
    }

    /**
     * 完整的异步回调函数，包括超时、异常处理及回调
     * 
     * @param supplier
     *            异步任务
     * @param duration
     *            超时时间
     * @param fn
     *            异常处理
     * @param action
     *            回调任务
     * @param <T>
     *            <T>
     * 
     */
    public static <T> void asyncCallBack(Supplier<T> supplier, Duration duration, Function<Throwable, ? extends T> fn,
            Consumer< ? super T> action)
    {
        within(supplier, duration).exceptionally(fn).thenAccept(action);
    }
}
