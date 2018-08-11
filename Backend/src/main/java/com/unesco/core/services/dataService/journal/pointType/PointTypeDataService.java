package com.unesco.core.services.dataService.journal.pointType;

import com.unesco.core.entities.journal.PointTypeEntity;
import com.unesco.core.dto.journal.PointTypeDTO;
import com.unesco.core.repositories.journal.PointTypeRepository;
import com.unesco.core.services.dataService.mapperService.IMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PointTypeDataService implements IPointTypeDataService {
    @Autowired
    private IMapperService mapperService;
    @Autowired
    private PointTypeRepository pointTypeRepository;

    public List<PointTypeDTO> getAll()
    {
        List<PointTypeDTO> modelList = new ArrayList<>();
        Iterable<PointTypeEntity> entityList = pointTypeRepository.findAll();
        for (PointTypeEntity item: entityList) {
            PointTypeDTO model = (PointTypeDTO) mapperService.toDto(item);
            modelList.add(model);
        }
        return modelList;
    }

    public PointTypeDTO get(long id)
    {
        PointTypeEntity entity = pointTypeRepository.findOne(id);
        PointTypeDTO model = (PointTypeDTO) mapperService.toDto(entity);
        return model;
    }

    public void delete(long id)
    {
        pointTypeRepository.delete(id);
    }

    public PointTypeDTO save(PointTypeDTO model)
    {
        PointTypeEntity entity = (PointTypeEntity) mapperService.toEntity(model);
        entity = pointTypeRepository.save(entity);
        model = (PointTypeDTO) mapperService.toDto(entity);
        return model;
    }

    public PointTypeDTO findByName(String name)
    {
        PointTypeEntity entity = pointTypeRepository.findByName(name);
        PointTypeDTO model = (PointTypeDTO) mapperService.toDto(entity);
        return model;
    }

}