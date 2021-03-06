package fr.percall.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.percall.skills.CollabFramLevel;
import fr.percall.skills.Frameworks;

public interface CollabFramLevelRepository extends JpaRepository<CollabFramLevel, Integer> {
		
	@Query(value = "select distinct f.name from collab_fram_level cfl, collaborators c, frameworks f where c.id = cfl.collaborators_id and"
			+ " f.id = cfl.frameworks_id and c.name = :name", nativeQuery = true)	
	List<CollabFramLevel> cfl(@Param("name")String name);
	
	@Query(value = "select distinct c.name, c.fname from collab_fram_level cfl, collaborators c, frameworks f where c.id = cfl.collaborators_id and"
			+ " f.id = cfl.frameworks_id and f.name = :fram", nativeQuery = true)	
	List<CollabFramLevel> fram(@Param("fram")String fram);
}
