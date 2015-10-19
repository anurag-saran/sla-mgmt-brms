package com.redhatbank.brms.tracktrace.database;

import java.util.HashMap;
import java.util.Map;

import com.redhatbank.brms.tracktrace.model.*;

public class TrackTraceDataBase {
  
	private static Map<String, TrackTraceModel> trackTrace = new HashMap<>();
  
  public static Map<String, TrackTraceModel> getTrackTrace() {
	  return trackTrace;
  }
}
