package com.redhatbank.brms.tracktrace.service;
import com.redhatbank.brms.tracktrace.model.*;
import com.redhatbank.brms.tracktrace.database.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TrackTraceService {
	
	private Map<String, TrackTraceModel> trackTraceMap = TrackTraceDataBase.getTrackTrace();
	
	public List<TrackTraceModel> getAllTrackTraceStatus() {
			return new ArrayList<TrackTraceModel>(trackTraceMap.values());
		
	}
	
	public TrackTraceModel getTrackTraceStatusByTT(String transType) {

		return trackTraceMap.get(transType);
	}
	

	public TrackTraceModel addTraceAndTracker(TrackTraceModel ttm) {
		//ttm.setTransactionType(transactionType);
		trackTraceMap.put(ttm.getTransactionType(), ttm);
		return ttm;
	}
	
	public TrackTraceModel updateTraceAndTracker(TrackTraceModel ttm) {
		//if(ttm.getTransactionType())
		trackTraceMap.put(ttm.getTransactionType(), ttm);	
		return ttm;
	}
	
	public TrackTraceModel removeTrackTrace(String transType) {
		return trackTraceMap.remove(transType);
	
	}
}
