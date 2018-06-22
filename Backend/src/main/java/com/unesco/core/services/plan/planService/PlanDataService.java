package com.unesco.core.services.plan.planService;

import com.unesco.core.entities.plan.PlanEntity;
import com.unesco.core.models.plan.PlanDTO;
import com.unesco.core.models.additional.FilterQueryDTO;
import com.unesco.core.repositories.plan.PlanRepository;
import com.unesco.core.services.mapperService.IMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanDataService implements IPlanDataService {

    @Autowired
    private IMapperService mapperService;
    @Autowired
    private PlanRepository planRepository;

    public List<PlanDTO> GetPage(FilterQueryDTO filter) {
        int rows = filter.getRows()>0? filter.getRows() : (int) planRepository.count();
        int start = rows>0 ? filter.getFirst()/rows: 1;
        List<PlanEntity> entitys = planRepository.findWithFilter(new PageRequest(start, rows == 0 ? 10 : rows), filter.getGlobalFilter());
        List<PlanDTO> result = new ArrayList<PlanDTO>();
        for (PlanEntity e: entitys) {
            result.add((PlanDTO) mapperService.toModel(e));
        }
        return result;
    }

    public List<PlanDTO> GetAll()
    {
        List<PlanDTO> modelList = new ArrayList<>();
        Iterable<PlanEntity> entityList = planRepository.findAll();
        for (PlanEntity item: entityList) {
            PlanDTO model = (PlanDTO) mapperService.toModel(item);
            modelList.add(model);
        }
        return modelList;
    }

    public PlanDTO Get(long id)
    {
        PlanEntity entity = planRepository.findOne(id);
        PlanDTO model = (PlanDTO) mapperService.toModel(entity);
        return model;
    }

    public void Delete(long id)
    {
        planRepository.delete(id);
    }

    public PlanDTO Save(PlanDTO plan)
    {
        PlanEntity entity = (PlanEntity) mapperService.toEntity(plan);
        PlanEntity model = planRepository.save(entity);
        plan = (PlanDTO) mapperService.toModel(model);
        return plan;
    }
}
