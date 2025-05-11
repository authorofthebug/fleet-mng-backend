package solutions.qowin.fleet.generictype.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenericType {
    private String id;
    
    private String name;
    private String description;
    private String category;
    private String status;
    private String code;

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