package sweetie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sweetie.entity.Review;
import sweetie.entity.Product;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByUser(sweetie.entity.User user);

    @Query("SELECT AVG(r.rating) FROM Review r")
    Double getAverageRating();
    // Thêm method tìm review theo product
    List<Review> findByProduct(Product product);
}
