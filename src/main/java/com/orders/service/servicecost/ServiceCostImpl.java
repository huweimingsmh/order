package com.orders.service.servicecost;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orders.dao.ServiceCost;
import com.orders.mapper.ServiceCostMapper;
import com.orders.service.ServiceCoseService;
import com.orders.service.message.MessageServiceImp;
import com.orders.vo.BaseServiceCost;
import com.orders.vo.ServiceCostVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceCostImpl implements ServiceCoseService {
    private static Logger log= LoggerFactory.getLogger(ServiceCostImpl.class);

    @Autowired
    private ServiceCostMapper constMapper;
    @Override
    public ServiceCostVo getServiceCost(){
        try {
            List<ServiceCost> costList = constMapper.getServiceCost();
            return serviceCostHelp(costList);
        }catch (Exception e){
            log.error(e.getMessage());
        }
       return null;
    }

    private ServiceCostVo serviceCostHelp(List<ServiceCost> costList){
        if(null!=costList){
            try {
                ServiceCostVo vo=new ServiceCostVo();
                Map<String, String> otherCost=new HashMap<>();
                for (ServiceCost tempCost : costList) {
                    if (null != tempCost) {
                        if (tempCost.equals("baseService")) {
                            ObjectMapper objMapper = new ObjectMapper();
                            List<BaseServiceCost> baseCostList = objMapper.readValue(tempCost.getCost(), new TypeReference<List<BaseServiceCost>>() {
                            });
                            vo.setBaseCost(baseCostList);
                        }
                    }else{
                        otherCost.put(tempCost.getName(),tempCost.getCost());
                    }
                }
                vo.setOtherCost(otherCost);
                return vo;
            }catch (Exception e){
                log.error(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public void setServiceCost() {

    }
}
