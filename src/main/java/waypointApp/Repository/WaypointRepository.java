package waypointApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import waypointApp.Model.Waypoint;

public interface WaypointRepository extends JpaRepository <Waypoint, Long>
{
}
