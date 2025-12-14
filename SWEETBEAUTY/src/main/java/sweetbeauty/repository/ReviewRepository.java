package sweetbeauty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sweetbeauty.entity.Review;
import sweetbeauty.entity.Product;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByUser(sweetbeauty.entity.User user);

    @Query("SELECT AVG(r.rating) FROM Review r")
    Double getAverageRating();
    // Thêm method tìm review theo product
    List<Review> findByProduct(Product product);
}