package com.moz.ates.traffic.police.gis.service;

import com.moz.ates.traffic.common.entity.common.AccidentDomain;
import com.moz.ates.traffic.common.entity.common.EnforcementDomain;

public interface GisService {
	
	public EnforcementDomain getMapInfo(String tfcEnfId);
	
	public AccidentDomain getAcMapInfo(String tfcAcdntId);
}
