package k23cnt3.btqn.day06.repository;

import k23cnt3.btqn.day06.entity.btqnAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BtqnAuthorRepository extends JpaRepository<btqnAuthor,Long> {
}
