package com.martingallauner.bookclub.adapter.out.persistence;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.martingallauner.bookclub.adapter.in.web.UserResponse;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
    private Set<UserEntity> connections = new HashSet<>();

    public void addConnection(UserEntity user) {
        this.connections.add(user);
        user.getConnections().add(this);
    }

    public void removeConnection(UserEntity person) {
        this.connections.remove(person);
        person.getConnections().remove(this);
    }


    public UserResponse toResponse() {
        Set<Long> friendIds = this.getConnections().stream()
                .map(UserEntity::getId)
                .collect(Collectors.toSet());

        return new UserResponse(this.getId(), this.getName(), this.getCreatedAt().toString(), friendIds);
    }
}
