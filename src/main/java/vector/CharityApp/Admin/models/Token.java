package vector.CharityApp.Admin.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import vector.CharityApp.Admin.TokenType;
import vector.CharityApp.Admin.User;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "token_seq")
    @SequenceGenerator(name = "token_seq", sequenceName = "token_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false, length = 1024)
    private String token;

    @Enumerated(EnumType.STRING)
    private TokenType tokenType = vector.CharityApp.Admin.models.TokenType.BEARER;

    private boolean revoked;

    private boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;


    @CreatedBy
    @Column(updatable = false)
    private String createdBy;



    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;



}