package solutions.qowin;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;

import java.io.ByteArrayInputStream;

/**
 * Configuration class to register serializers for Java standard library classes
 * that Micronaut Serialization needs to handle.
 */
@Introspected
@SerdeImport(ByteArrayInputStream.class)
public class SerdeConfiguration {
    // This class doesn't need any implementation
    // It just serves as a holder for the SerdeImport annotation
}
