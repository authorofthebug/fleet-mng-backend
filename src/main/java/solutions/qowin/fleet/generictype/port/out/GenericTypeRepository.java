package solutions.qowin.fleet.generictype.port.out;


import solutions.qowin.fleet.generictype.domain.model.GenericType;

import java.util.List;
import java.util.Optional;

public interface GenericTypeRepository {
    GenericType save(GenericType genericType);
    GenericType update(GenericType genericType);
    Optional<GenericType> findById(String id);
    void deleteById(String id);
    List<GenericType> getbyCategoryAndStatus(String category, String status);
} 