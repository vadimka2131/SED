package com.unesco.core.managers.plan.planManager;

import com.unesco.core.managers.plan.planManager.interfaces.planList.IPlanListManager;
import com.unesco.core.dto.plan.PlanDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class PlanListManager implements IPlanListManager {

    public List<PlanDTO> planList;

    public PlanListManager() {
        planList = new ArrayList<>();
    }

    public void init(List<PlanDTO> PlanList) {
        planList = PlanList;
    }

    public List<PlanDTO> getAll() {
        return planList;
    }
}
