package app.dao.jpaInterface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.Parther;
import app.model.User;

@Repository
public interface PartherRepository extends JpaRepository <Parther,Long>{
	public Parther findById(long id);
        public Parther findByUserId(User user);
}
