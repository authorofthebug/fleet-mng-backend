package solutions.qowin;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.proxy.payload1.ApiGatewayProxyRequestEventFunction;

/**
 * Lambda handler for API Gateway integration.
 *
 * This handler processes API Gateway proxy integration requests and routes them
 * to the appropriate Micronaut controllers.
 */
@Introspected
public class LambdaHandler extends ApiGatewayProxyRequestEventFunction {
    // No need to override any methods - the parent class handles everything
}