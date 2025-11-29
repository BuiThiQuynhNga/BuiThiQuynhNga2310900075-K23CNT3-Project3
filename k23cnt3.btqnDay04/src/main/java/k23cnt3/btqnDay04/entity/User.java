package k23cnt3.btqnDay04.entity;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults (level = AccessLevel. PRIVATE)
@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String username;
    String password;
    String fullName;
    LocalDate birthday;
    String email;
    String phone;
    int age;
    Boolean status;
}

