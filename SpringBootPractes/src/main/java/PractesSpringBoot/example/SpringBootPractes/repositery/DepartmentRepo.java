package PractesSpringBoot.example.SpringBootPractes.repositery;

import PractesSpringBoot.example.SpringBootPractes.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department , Long> {

  public Department findByDepartmentName(String name);
  public Department findByDepartmentCode(String code);
}
