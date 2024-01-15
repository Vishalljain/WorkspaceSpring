/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peng.PropertyDescriptor;

/**
 *
 * @author IXL1KOR
 */
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import org.apache.commons.beanutils.PropertyUtils;


public class Project {
    private String projectName;
    private int projectStatus;

    public Project(String projectName, int projectStatus) {
        this.projectName = projectName;
        this.projectStatus = projectStatus;
    }
    
    public Project(){
        
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(int projectStatus) {
        this.projectStatus = projectStatus;
    }

    // Constructor, getters, and setters...

    public void editProjectData(Project otherProject) {
        try {
            PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(this.getClass());

            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                System.out.println("---"+propertyDescriptor);
                String name = propertyDescriptor.getName();
                if (!"class".equalsIgnoreCase(name)) {
                    Method writeMethod = propertyDescriptor.getWriteMethod();
                    Method readMethod = propertyDescriptor.getReadMethod();
                    
                    if (writeMethod != null && readMethod != null) {
                        Object readValue = readMethod.invoke(this);
                        Object readValue2 = readMethod.invoke(otherProject);

                        if (!readValue.equals(readValue2)) {
                            writeMethod.invoke(this, readValue2);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create two Project objects
        Project project1 = new Project();
        project1.setProjectName("Project A");
        project1.setProjectStatus(1);

        Project project2 = new Project();
        project2.setProjectName("Project B");
        project2.setProjectStatus(2);

        // Print initial values
        System.out.println("Before editProjectData:");
        System.out.println("Project 1: " + project1.getProjectName() + ", Status: " + project1.getProjectStatus());
        System.out.println("Project 2: " + project2.getProjectName() + ", Status: " + project2.getProjectStatus());

        // Use editProjectData to synchronize data
        project1.editProjectData(project2);

        // Print values after synchronization
        System.out.println("\nAfter editProjectData:");
        System.out.println("Project 1: " + project1.getProjectName() + ", Status: " + project1.getProjectStatus());
        System.out.println("Project 2: " + project2.getProjectName() + ", Status: " + project2.getProjectStatus());
    }
}
