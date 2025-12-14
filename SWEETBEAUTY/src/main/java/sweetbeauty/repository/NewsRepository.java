package sweetbeauty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sweetbeauty.entity.News;

public interface NewsRepository extends JpaRepository<News, Long> {
}