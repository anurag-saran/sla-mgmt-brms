package com.redhatbank.brms.tracktrace;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.redhatbank.brms.tracktrace.service.TrackTraceService;
import com.redhatbank.brms.tracktrace.model.*;

@Path("/tracktrace")
public class TrackTrace {
	
	TrackTraceService tracktrackservice = new TrackTraceService();
	
	// GET
	// http://localhost:8080/tracktrace/webapi/tracktrace/AllTrackerStatus
	@GET
	@Path("/AllTrackerStatus")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrackTraceModel> getAllTrackerStatus(){
		return tracktrackservice.getAllTrackTraceStatus();
		
	}
	
	// GET
	// http://localhost:8080/tracktrace/webapi/tracktrace/TrackerStatus/{TransactionType}
	@GET
	@Path("/TrackerStatus/{transactionType}")
	@Produces(MediaType.APPLICATION_JSON)
	public TrackTraceModel getTrackTraceStatusByTT(@PathParam("transactionType") String transType){
		return tracktrackservice.getTrackTraceStatusByTT(transType);
		
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
	@POST
	@Path("/AddTrackTrace")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TrackTraceModel addTraceAndTracker(TrackTraceModel ttm){
		return tracktrackservice.addTraceAndTracker(ttm);
	}
	
	// PUT
	// http://localhost:8080/tracktrace/webapi/tracktrace/UpdateTrackTrace/{TransactionType}
	@PUT
	@Path("/UpdateTrackTrace/{transactionType}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TrackTraceModel updateTraceAndTracker(@PathParam("transactionType") String transType, TrackTraceModel ttm){
		ttm.setTransactionType(transType);
		return tracktrackservice.updateTraceAndTracker(ttm);
	}
}
