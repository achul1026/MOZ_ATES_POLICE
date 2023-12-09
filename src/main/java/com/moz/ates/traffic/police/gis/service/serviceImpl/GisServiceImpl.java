package com.moz.ates.traffic.police.gis.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moz.ates.traffic.common.entity.common.AccidentDomain;
import com.moz.ates.traffic.common.entity.common.EnforcementDomain;
import com.moz.ates.traffic.common.repository.common.GisRepository;
import com.moz.ates.traffic.police.gis.service.GisService;

@Service
public class GisServiceImpl implements GisService{
	
	@Autowired
	GisRepository gisRepository;
	
	@Override
	public EnforcementDomain getMapInfo(String tfcEnfId) {
		return gisRepository.selectEnforcementList(tfcEnfId);
	}

	@Override
	public AccidentDomain getAcMapInfo(String tfcAcdntId) {
		return gisRepository.selectAccidentList(tfcAcdntId);
	}
	
}
