package PractesSpringBoot.example.SpringBootPractes.service;

import PractesSpringBoot.example.SpringBootPractes.entity.Department;
import PractesSpringBoot.example.SpringBootPractes.repositery.DepartmentRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DepartmentServiceImplementaion implements DepartmentService{


    private final DepartmentRepo departmentRepo;

    public DepartmentServiceImplementaion(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }


    @Override
    public void SaveDepartment(Department department) {

        departmentRepo.save(department);

    }

    @Override
    public ArrayList<Department> getAllDepartments() {

        ArrayList<Department> departmentArrayList = (ArrayList<Department>) departmentRepo.findAll();
        return departmentArrayList;
    }

    @Override
    public Department findDepartmentbyID(Long id) {

        Department department =(Department) departmentRepo.findById(id).get();
        return department ;
    }

    @Override
    public void DeletAll() {

        departmentRepo.deleteAll();
    }

    @Override
    public void DeletbyID(Long id) {

        departmentRepo.deleteById(id);
    }

    @Override
    public void Update(Long id , Department department1) {

        Department department = (Department) departmentRepo.findById(id).get();
        department.setDepartmentAddress(department1.getDepartmentAddress());
        department.setDepartmentName(department1.getDepartmentName());
        department.setDepartmentCode(department1.getDepartmentCode());

departmentRepo.deleteById(id);
        departmentRepo.save(department1);

    }

    @Override
    public Department findDepartmentByName(String name) {

        return departmentRepo.findByDepartmentName(name);
    }

    @Override
    public Department findDepartmenByCode(String code) {


        return departmentRepo.findByDepartmentCode(code);
    }
}

