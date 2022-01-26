package a3.emsi.theislamway.dao;

import a3.emsi.theislamway.entities.Hizb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HizbRepository extends JpaRepository<Hizb, Integer> {
}
