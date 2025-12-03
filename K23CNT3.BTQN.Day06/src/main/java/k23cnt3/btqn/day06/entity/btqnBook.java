package k23cnt3.btqn.day06.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class btqnBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long btqnId;

    String btqnCode;
    String btqnName;
    String btqnDescription;
    String btqnImgUrl;
    Integer btqnQuantity;
    Double btqnPrice;
    Boolean btqnActive;

    // Many-to-Many with Author
    @ManyToMany
    @JoinTable(
            name = "btqn_book_author",
            joinColumns = @JoinColumn(name = "btqnBookId"),
            inverseJoinColumns = @JoinColumn(name = "btqnAuthorId")
    )
    List<btqnAuthor> btqnAuthors = new ArrayList<>();

}
