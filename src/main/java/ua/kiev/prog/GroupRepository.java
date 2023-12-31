package ua.kiev.prog;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// DAO
public interface GroupRepository extends JpaRepository<Group, Long> {
    @Query("SELECT c FROM Group c WHERE c.name = :name")
    List<Contact> findByName(@Param("name") String name);
}
