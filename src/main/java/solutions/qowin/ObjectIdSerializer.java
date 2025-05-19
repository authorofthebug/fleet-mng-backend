package solutions.qowin;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.type.Argument;
import io.micronaut.serde.Decoder;
import io.micronaut.serde.Encoder;
import io.micronaut.serde.Serde;
import org.bson.types.ObjectId;

import java.io.IOException;

/**
 * Custom serializer for MongoDB's ObjectId.
 * Converts ObjectId to/from String for proper JSON serialization.
 */
@Introspected
public class ObjectIdSerializer implements Serde<ObjectId> {

    @Override
    public ObjectId deserialize(Decoder decoder, DecoderContext context, Argument<? super ObjectId> type) throws IOException {
        String value = decoder.decodeString();
        return value == null || value.isEmpty() ? null : new ObjectId(value);
    }

    @Override
    public void serialize(Encoder encoder, EncoderContext context, Argument<? extends ObjectId> type, ObjectId value) throws IOException {
        if (value == null) {
            encoder.encodeNull();
        } else {
            encoder.encodeString(value.toString());
        }
    }
}
