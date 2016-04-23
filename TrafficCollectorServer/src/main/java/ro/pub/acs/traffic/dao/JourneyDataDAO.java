package ro.pub.acs.traffic.dao;

import java.io.Serializable;
import java.util.*;
import ro.pub.acs.traffic.model.*;

public interface JourneyDataDAO extends Serializable {
	public JourneyData get(int id);

	public int update(JourneyData journey);
	
	public List<JourneyData> getByJourneyId(Journey journeyId);

	public int add(JourneyData journey);
	
	public double maxSpeed(Journey journey);
	
	public double minSpeed(Journey journey);
}