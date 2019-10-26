package com.meiyukai.ssm.service.impl;

import com.meiyukai.ssm.dao.ITravellerDao;
import com.meiyukai.ssm.domain.Traveller;
import com.meiyukai.ssm.service.ITravellerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "travellerService")
@Transactional
public class TravellerServiceImpl implements ITravellerService {
    @Resource(name = "travellerDao")
    private ITravellerDao travellerDao;

    @Override
    public List<Traveller> findAll() {
        return travellerDao.findAll();
    }

    @Override
    public Traveller findTravellerById(String id) {
        return travellerDao.findTravellerById(id);
    }

    @Override
    public List<Traveller> findTravellerByOrderId(String orderId) {
        return travellerDao.findTravellerByOrderId(orderId);
    }
}
