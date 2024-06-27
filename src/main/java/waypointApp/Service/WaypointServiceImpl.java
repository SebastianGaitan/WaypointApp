package waypointApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import waypointApp.Model.Waypoint;
import waypointApp.Repository.WaypointRepository;

import java.util.Optional;

@Service
public class WaypointServiceImpl implements WaypointService
{
	private final WaypointRepository waypointRepository;

	@Autowired
	public WaypointServiceImpl ( WaypointRepository waypointRepository )
	{
		this.waypointRepository = waypointRepository;
	}

	@Override
	public Waypoint saveWaypoint ( Waypoint waypoint )
	{
		return waypointRepository.save (waypoint);
	}

	@Override
	public java.util.List <Waypoint> getAllWaypoints ( )
	{
		return waypointRepository.findAll ( );
	}

	@Override
	public Optional <Waypoint> getWaypointById ( Long id )
	{
		return waypointRepository.findById (id);
	}

	@Override
	public Waypoint updateWaypoint ( Long id, Waypoint waypoint )
	{
		if ( waypointRepository.existsById (id) ) {
			waypoint.setId (id);
			return waypointRepository.save (waypoint);
		}
		return null;
	}

	@Override
	public void deleteWaypoint ( Long id )
	{
		waypointRepository.deleteById (id);
	}
}
