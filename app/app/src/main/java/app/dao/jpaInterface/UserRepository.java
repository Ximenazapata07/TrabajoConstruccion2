package app.dao.jpaInterface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.User;


@Repository
public interface UserRepository extends JpaRepository <User,Long>{

	public User findByUserName(String userName) ;

	public boolean existsByUserName(String userName);
		
}
