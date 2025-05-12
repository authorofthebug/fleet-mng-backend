package solutions.qowin.fleet.generictype.application.service;

import jakarta.inject.Singleton;
import solutions.qowin.fleet.generictype.domain.model.GenericType;
import solutions.qowin.fleet.generictype.port.in.ManagementGenericTypeUseCase;
import solutions.qowin.fleet.generictype.port.out.GenericTypeRepository;

import java.util.List;

@Singleton
public class GenericTypeService implements ManagementGenericTypeUseCase {
    
    private final GenericTypeRepository genericTypeRepository;

    public GenericTypeService(GenericTypeRepository genericTypeRepository) {
        this.genericTypeRepository = genericTypeRepository;
    }

    @Override
    public GenericType create(GenericType genericType) {
        return genericTypeRepository.save(genericType);
    }

    @Override
    public GenericType update(GenericType genericType) {
        return genericTypeRepository.update(genericType);
    }

    @Override
    public void delete(String id) {
        genericTypeRepository.deleteById(id);
    }

    @Override
    public GenericType findById(String id) {
        return genericTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("GenericType not found"));
    }

    @Override
    public List<GenericType> getbyCategoryAndStatus(String category, String status) {
        return genericTypeRepository.getbyCategoryAndStatus(category, status);
    }

    @Override
    public List<GenericType> getAllActives() {
        return genericTypeRepository.getAllActives();
    }
} 