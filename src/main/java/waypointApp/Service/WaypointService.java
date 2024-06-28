package waypointApp.Service;

import waypointApp.Model.Waypoint;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface WaypointService
{
	Waypoint saveWaypoint ( Waypoint waypoint );

	List <Waypoint> getAllWaypoints ( );

	Optional <Waypoint> getWaypointById ( Long id );

	Waypoint updateWaypoint ( Long id, Waypoint waypoint );

	void deleteWaypoint ( Long id );

	Optional <Waypoint> updateWaypointNameAndDescription ( Long id, Map <String, Object> updates );
}
