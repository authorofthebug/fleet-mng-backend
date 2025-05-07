package solutions.qowin.fleet.client.infrastructure.controller.rest.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Introspected
@Serdeable
@NoArgsConstructor
@AllArgsConstructor
public class CreateClientRequest {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String taxId;
    private String status;
    private String notes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

} 