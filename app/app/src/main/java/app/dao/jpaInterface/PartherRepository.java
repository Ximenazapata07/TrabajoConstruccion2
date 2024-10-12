package app.dao.jpaInterface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.Parther;

@Repository
public interface PartherRepository extends JpaRepository <Parther,Long>{
	public Parther findById(long id);

}
