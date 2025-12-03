package k23cnt3.btqn.day06.repository;

import k23cnt3.btqn.day06.entity.btqnBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BtqnBookRepository extends JpaRepository<btqnBook,Long> {
}
