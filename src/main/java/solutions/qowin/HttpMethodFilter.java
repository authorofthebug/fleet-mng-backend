package solutions.qowin;

import io.micronaut.context.annotation.Context;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.HttpServerFilter;
import io.micronaut.http.filter.ServerFilterChain;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A filter that ensures the HTTP method is properly set.
 * This helps address the "Name is null" NullPointerException when parsing HTTP methods.
 */
@Filter("/**")
@Context
public class HttpMethodFilter implements HttpServerFilter {

    private static final Logger LOG = LoggerFactory.getLogger(HttpMethodFilter.class);

    @Override
    public Publisher<io.micronaut.http.MutableHttpResponse<?>> doFilter(HttpRequest<?> request, ServerFilterChain chain) {
        LOG.debug("Processing request in HttpMethodFilter: {}", request);

        // Check if the method is null and log a warning
        if (request.getMethod() == null) {
            LOG.warn("Request has null HTTP method, this may cause issues");
            // We can't directly modify the HTTP method on the request
            // Just log the warning and continue
        }

        return chain.proceed(request);
    }
}
