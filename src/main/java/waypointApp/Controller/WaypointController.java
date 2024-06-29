package waypointApp.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import waypointApp.Model.Waypoint;
import waypointApp.Service.WaypointService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping ("/api/waypoint")
@CrossOrigin (origins = "http://waypointapp-frontend.s3-website-us-east-1.amazonaws.com")
public class WaypointController
{
	private final WaypointService waypointService;

	@Autowired
	public WaypointController ( WaypointService waypointService )
	{
		this.waypointService = waypointService;
	}

	@PostMapping
	public ResponseEntity <Waypoint> createWaypoint ( @RequestBody Waypoint waypoint )
	{
		Waypoint savedWaypoint = waypointService.saveWaypoint (waypoint);
		return ResponseEntity.ok (savedWaypoint);
	}

	@GetMapping
	public ResponseEntity <List <Waypoint>> getAllWaypoints ( )
	{
		List <Waypoint> waypoints = waypointService.getAllWaypoints ( );
		return ResponseEntity.ok (waypoints);
	}

	@GetMapping ("/{id}")
	public ResponseEntity <Waypoint> getWaypointById ( @PathVariable Long id )
	{
		Optional <Waypoint> waypoint = waypointService.getWaypointById (id);
		return waypoint.map (ResponseEntity::ok).orElseGet (( ) -> ResponseEntity.notFound ( ).build ( ));
	}

	@PutMapping ("/{id}")
	public ResponseEntity <Waypoint> updateWaypoint ( @PathVariable Long id, @RequestBody Waypoint waypoint )
	{
		Waypoint updatedWaypoint = waypointService.updateWaypoint (id, waypoint);
		if ( updatedWaypoint != null ) {
			return ResponseEntity.ok (updatedWaypoint);
		}
		return ResponseEntity.notFound ( ).build ( );
	}

	@PatchMapping ("/{id}")
	public ResponseEntity <Waypoint> updateWaypointNameAndDescription ( @PathVariable Long id, @RequestBody Map <String, Object> updates )
	{
		Optional <Waypoint> optionalWaypoint = waypointService.updateWaypointNameAndDescription (id, updates);
		return optionalWaypoint.map (ResponseEntity::ok).orElseGet (( ) -> ResponseEntity.notFound ( ).build ( ));
	}

	@DeleteMapping ("/{id}")
	public ResponseEntity <Void> deleteWaypoint ( @PathVariable Long id )
	{
		waypointService.deleteWaypoint (id);
		return ResponseEntity.noContent ( ).build ( );
	}
}
