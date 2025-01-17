package AgriMarketBackend.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AgriMarketBackend.Entity.Category;



@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {

}
