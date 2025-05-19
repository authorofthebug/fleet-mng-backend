package solutions.qowin;

import io.micronaut.context.annotation.Context;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.filter.HttpServerFilter;
import io.micronaut.http.filter.ServerFilterChain;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A simple request logger that logs details about incoming HTTP requests.
 * This helps diagnose issues with API Gateway integration.
 */
@Singleton
@Context
public class RequestLogger implements HttpServerFilter {

    private static final Logger LOG = LoggerFactory.getLogger(RequestLogger.class);

    @Override
    public Publisher<io.micronaut.http.MutableHttpResponse<?>> doFilter(HttpRequest<?> request, ServerFilterChain chain) {
        LOG.info("Received request: {} {}", request.getMethod(), request.getPath());
        LOG.debug("Request headers: {}", request.getHeaders().asMap());
        return chain.proceed(request);
    }

    @Override
    public int getOrder() {
        return 0; // High priority
    }
}
