package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.model.UserRole;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class UserRoleRepository implements PanacheRepositoryBase<UserRole, Long> {
    public Optional<UserRole> findByName(String name){
        return find("role_name", name).firstResultOptional();
    }
}
