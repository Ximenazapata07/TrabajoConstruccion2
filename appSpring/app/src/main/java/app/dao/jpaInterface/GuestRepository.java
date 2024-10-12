package app.dao.jpaInterface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.Guest;

@Repository
public interface GuestRepository extends JpaRepository <Guest,Long>{
	public Guest findById(long id);
	
}
