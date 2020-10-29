package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompensationServiceImpl implements CompensationService {

    @Autowired
    private CompensationRepository compensationRepository;
    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Override
    public List<Compensation> GetCompensationByEmpID(String id) {
        if(id == null || id.equals("") || id.isEmpty())
        {
            throw new NullPointerException("No Id found");
        }
        return compensationRepository.findByEmployeeEmployeeId(id);
    }

    @Override
    public Compensation Create(Compensation compensation) {
        //compensation.setCompensationID(UUID.randomUUID().toString());
        try {
            compensationRepository.insert(compensation);
        }catch(Exception e){
            System.out.println(e.getStackTrace());
        }

        return compensation;
    }
}
