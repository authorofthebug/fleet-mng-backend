package solutions.qowin.fleet.schedule.infrastructure.config;

import io.micronaut.context.annotation.Factory;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import io.micronaut.context.annotation.Value;

/**
 * MongoDB configuration for the application.
 */
@Factory
public class MongoDbConfig {
  private static final Logger LOG = LoggerFactory.getLogger(MongoDbConfig.class);

  @Value("${mongodb.uri}")
  private String mongoUri;

  /**
   * Creates a MongoClient bean for connecting to MongoDB.
   *
   * @return The configured MongoClient
   */
  @Singleton
  public MongoClient mongoClient() {
    LOG.info("Connecting to MongoDB with URI: {}", mongoUri);
    try {
      MongoClient client = MongoClients.create(mongoUri);
      LOG.info("Successfully connected to MongoDB");
      return client;
    } catch (Exception e) {
      LOG.error("Failed to connect to MongoDB: {}", e.getMessage(), e);
      throw e;
    }
  }
}
