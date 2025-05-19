package solutions.qowin;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.proxy.payload1.ApiGatewayProxyRequestEventFunction;

/**
 * Lambda handler for API Gateway proxy integration.
 *
 * This handler extends ApiGatewayProxyRequestEventFunction which is specifically
 * designed to handle API Gateway proxy integration requests and properly map them
 * to Micronaut controllers.
 */
@Introspected
public class ApiGatewayHandler extends ApiGatewayProxyRequestEventFunction {

    static {
        // Log when the handler is loaded
        System.out.println("ApiGatewayHandler class loaded");
    }

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        // Ensure the HTTP method is set
        if (input.getHttpMethod() == null) {
            // Try to get the method from the request context
            if (input.getRequestContext() != null && input.getRequestContext().getHttpMethod() != null) {
                input.setHttpMethod(input.getRequestContext().getHttpMethod());
            } else {
                // Default to GET if we can't determine the method
                input.setHttpMethod("GET");
            }
        }

        // Log the request for debugging
        System.out.println("Processing request: " + input.getHttpMethod() + " " + input.getPath());

        // Call the parent implementation
        return super.handleRequest(input, context);
    }
}
