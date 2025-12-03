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
public class btqnAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long btqnId;

    String btqnCode;
    String btqnName;
    String btqnDescription;
    String btqnImgUrl;
    String btqnEmail;
    String btqnPhone;
    String btqnAddress;
    Boolean btqnActive;

    // Quan hệ đúng với btqnBook (tên phải khớp!)
    @ManyToMany(mappedBy = "btqnAuthors")
    List<btqnBook> btqnBooks = new ArrayList<>();

}
