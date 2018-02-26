package com.herusantoso.redis.redisexample.queue;

public interface MessagePublisher {
    void publish(final String message);
}
