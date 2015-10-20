package com.redhat.poc.bankingservice.services;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;

import com.redhat.poc.bankingservice.model.TrackTraceModel;

@Singleton
public class TrackTraceService {
	
	private Map<String, TrackTraceModel> trackTraceMap = null;
	
	public List<TrackTraceModel> getAllTrackTraceStatus() {
			return new ArrayList<TrackTraceModel>(getTrackTraceMap().values());
		
	}
	
	public void clearAllTrackTraceStatus() {
		getTrackTraceMap().clear();	
	}
	
	public TrackTraceModel getTrackTraceStatusByTT(String transType) {

		return getTrackTraceMap().get(transType);
	}
	

	public TrackTraceModel addTraceAndTracker(TrackTraceModel ttm) {
		getTrackTraceMap().put(ttm.getTransactionType(), ttm);
		return ttm;
	}
	
	public TrackTraceModel updateTraceAndTracker(TrackTraceModel ttm) {

		getTrackTraceMap().put(ttm.getTransactionType(), ttm);	
		return ttm;
	}
	
	public TrackTraceModel removeTrackTrace(String transType) {
		return getTrackTraceMap().remove(transType);
	
	}
	
	private Map<String, TrackTraceModel> getTrackTraceMap() {
		
		if (trackTraceMap == null ) {
			trackTraceMap = new HashMap<String, TrackTraceModel>();
		}
		
		return trackTraceMap;
		
	}
}
