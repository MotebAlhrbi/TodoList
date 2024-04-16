package PractesSpringBoot.example.SpringBootPractes.service;

import PractesSpringBoot.example.SpringBootPractes.entity.Department;

import java.util.ArrayList;

public interface DepartmentService {

    public void SaveDepartment(Department department);

    public ArrayList<Department> getAllDepartments();

    public Department findDepartmentbyID(Long id);

    public void DeletAll();

    public void DeletbyID(Long id);


    public void Update(Long id , Department department);

    public Department findDepartmentByName(String name);

    public Department findDepartmenByCode(String code);
}
