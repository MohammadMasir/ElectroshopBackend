package com.zapter.zapter_backend.product.service;

import com.zapter.zapter_backend.product.domain.Model;
import com.zapter.zapter_backend.product.dto.model.ModelResponse;
import com.zapter.zapter_backend.product.dto.model.NewModel;
import com.zapter.zapter_backend.product.mapper.ModelMapper;
import com.zapter.zapter_backend.product.repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class    ModelService {
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public ModelService(ModelRepository modelRepository, ModelMapper modelMapper){
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    public void create(NewModel newModel){
        modelRepository.save(modelMapper.toModel(newModel));
    }

    public void update(Model model){
        modelRepository.save(model);
    }

    public void delete(Long id){
        try {
            modelRepository.deleteById(id);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

    public List<ModelResponse> get(){
        try {
            return modelMapper.toListOfModelResponse(modelRepository.findAll());
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }
    public ModelResponse getById(Long id){
        try {
            return modelMapper.toModelResponse(modelRepository.findById(id).orElseThrow(RuntimeException::new));
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }
}
