package solutions.qowin.fleet.generictype.port.in;

import solutions.qowin.fleet.generictype.domain.model.GenericType;

import java.util.List;

public interface ManagementGenericTypeUseCase {
    GenericType create(GenericType genericType);
    GenericType update(GenericType genericType);
    void delete(String id);
    GenericType findById(String id);
    List<GenericType> getbyCategoryAndStatus(String category, String status);
} 