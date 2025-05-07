package solutions.qowin.fleet.client.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Entity representing a client in the fleet management system.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private String id;
    
    private String name;
    
    private String email;
    
    private String phone;
    
    private String address;
    
    private String taxId;
    
    private String status;
    
    private String notes;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
    
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
} 