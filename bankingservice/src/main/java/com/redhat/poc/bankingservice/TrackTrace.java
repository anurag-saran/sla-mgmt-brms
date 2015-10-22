package com.redhat.poc.bankingservice;


import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.redhat.poc.bankingservice.model.TrackTraceModel;
import com.redhat.poc.bankingservice.services.TrackTraceService;

@Path("/")
public class TrackTrace {
		
	@Inject
	TrackTraceService tracktrackservice;
	
	// GET
	// http://localhost:8080/bankingservice/rest/AllTrackerStatus
	@GET
	@Path("/AllTrackerStatus")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrackTraceModel> getAllTrackerStatus(){
		return tracktrackservice.getAllTrackTraceStatus();
		
	}
	
	// GET
	// http://localhost:8080/bankingservice/rest/ClearAllTrackerStatus
	@GET
	@Path("/ClearAllTrackerStatus")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrackTraceModel> clearAllTrackerStatus(){
		return tracktrackservice.getAllTrackTraceStatus();
			
	}
	
	// GET
	// http://localhost:8080/bankingservice/rest/TrackerStatus/{TransactionType}
	@GET
	@Path("/TrackerStatus/{transactionType}")
	@Produces(MediaType.APPLICATION_JSON)
	public TrackTraceModel getTrackTraceStatusByTT(@PathParam("transactionType") String transType){
		return tracktrackservice.getTrackTraceStatusByTT(transType);
		
	}
	
	// POST
	// http://localhost:8080/bankingservice/rest/AddTrackTrace
	//
	//	  {
	//		    "errorTransactions": 0,
	//		    "logMessage": "",
	//		    "noOfTransProcessed": 0,
	//		    "successfullTrans": 0,
	//		    "totalTransactions": 500,
	//		    "transactionType": "aaa"
	//		  }
	@POST
	@Path("/AddTrackTrace")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TrackTraceModel addTraceAndTracker(TrackTraceModel ttm){
		return tracktrackservice.addTraceAndTracker(ttm);
	}
	
	// PUT
	// http://localhost:8080/bankingservice/rest/UpdateTrackTrace/{TransactionType}
	@PUT
	@Path("/UpdateTrackTrace/{transactionType}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TrackTraceModel updateTraceAndTracker(@PathParam("transactionType") String transType, TrackTraceModel ttm){
		ttm.setTransactionType(transType);
		return tracktrackservice.updateTraceAndTracker(ttm);
	}
}
