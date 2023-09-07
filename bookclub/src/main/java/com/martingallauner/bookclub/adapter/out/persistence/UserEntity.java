package com.martingallauner.bookclub.adapter.out.persistence;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.martingallauner.bookclub.application.domain.model.UserModel;
import com.martingallauner.bookclub.application.port.in.response.UserResponse;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@Table(name = "users")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    private LocalDateTime createdAt;

    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_books",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "books_id"))
    private Set<BookEntity> books;

    @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(
            name = "Connection",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "connection_id")
    )
    private List<UserEntity> connections = new ArrayList<>();

    public void addConnection(UserEntity user) {
        this.connections.add(user);
        user.getConnections().add(this);
    }

    public void removeConnection(UserEntity person) {
        this.connections.remove(person);
        person.getConnections().remove(this);
    }

    public UserModel toModel() {
        return UserModel.builder()
                .id(this.getId())
                .name(this.getName())
                .createdAt(this.getCreatedAt())
                .books(this.getBooks().stream().map(BookEntity::toModel).toList())
                .build();
    }
}
