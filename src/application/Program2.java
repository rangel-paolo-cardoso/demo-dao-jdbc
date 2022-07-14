package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TESTE 1: department findById ===");
        Department department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println("\n=== TESTE 2: department findAll ===");
        List<Department> list = departmentDao.findAll();
        list.forEach(System.out::println);

        System.out.println("\n=== TESTE 3: department insert ===");
        Department department2 = new Department(null, "Music");
        departmentDao.insert(department2);
        System.out.println("Inserted! New id = " + department2.getId());

        System.out.println("\n=== TESTE 4: department update ===");
        department2 = departmentDao.findById(8);
        department2.setName("Military");
        departmentDao.update(department2);
        System.out.println("Update completed!");

        System.out.println("\n=== TESTE 5: department delete ===");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed!");

        sc.close();
    }
}
