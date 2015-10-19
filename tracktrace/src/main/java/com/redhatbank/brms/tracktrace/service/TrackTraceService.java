package com.redhatbank.brms.tracktrace.service;
import com.redhatbank.brms.tracktrace.model.*;
import com.redhatbank.brms.tracktrace.database.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TrackTraceService {
	
	private Map<String, TrackTraceModel> trackTraceMap = TrackTraceDataBase.getTrackTrace();
	
	// GET
	// http://localhost:8080/tracktrace/webapi/tracktrace/AllTrackerStatus
	public List<TrackTraceModel> getAllTrackTraceStatus() {
			return new ArrayList<TrackTraceModel>(trackTraceMap.values());
		
	}
	// GET
	// http://localhost:8080/tracktrace/webapi/tracktrace/TrackerStatus/{TransactionType}
	public TrackTraceModel getTrackTraceStatusByTT(String transType) {

		return trackTraceMap.get(transType);
	}
	
	// POST
	// http://localhost:8080/tracktrace/webapi/tracktrace/AddTrackTrace
	//
	//	  {
	//		    "errorTransactions": 0,
	//		    "logMessage": "",
	//		    "noOfTransProcessed": 0,
	//		    "successfullTrans": 0,
	//		    "totalTransactions": 500,
	//		    "transactionType": "aaa"
	//		  }
	public TrackTraceModel addTraceAndTracker(TrackTraceModel ttm) {
		//ttm.setTransactionType(transactionType);
		trackTraceMap.put(ttm.getTransactionType(), ttm);
		return ttm;
	}
	
	// PUT
	// http://localhost:8080/tracktrace/webapi/tracktrace/UpdateTrackTrace/{TransactionType}
	public TrackTraceModel updateTraceAndTracker(TrackTraceModel ttm) {
		//if(ttm.getTransactionType())
		trackTraceMap.put(ttm.getTransactionType(), ttm);	
		return ttm;
	}
	
	public TrackTraceModel removeTrackTrace(String transType) {
		return trackTraceMap.remove(transType);
	
	}
}
