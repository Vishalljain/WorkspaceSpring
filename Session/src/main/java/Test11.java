/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author IXL1KOR
 */

// BlockInterface.java
 interface BlockInterface {
    void process();
}

// BlockData.java
 class BlockData implements BlockInterface {
    private Test11 test;
    private String data;

    public BlockData(Test11 test) {
        this.test = test;
        this.data = "Initial Data";
    }

    @Override
    public void process() {
        // Perform processing using data and reference to the Test instance
        System.out.println("Processing data in BlockData for Test instance: " + test);
        System.out.println("Data: " + data);
    }
}

// TestBlock.java
 class TestBlock implements BlockInterface {
    private Test11 test;
    private int value;

    public TestBlock(Test11 test) {
        this.test = test;
        this.value = 42;
    }

    @Override
    public void process() {
        // Perform processing using value and reference to the Test instance
        System.out.println("Processing value in TestBlock for Test instance: " + test);
        System.out.println("Value: " + value);
    }
}

// Test.java
public class Test11 {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    private int age;

    public Test11() {
        this.name = "DefaultName";
        this.age = 25;

        // Create instances of BlockData and TestBlock, passing the reference to the current Test instance
        BlockData blockData = new BlockData(this);
        TestBlock testBlock = new TestBlock(this);
        this.age=30;

        // Process data in BlockData and TestBlock
        blockData.process();
        testBlock.process();
    }

    @Override
    public String toString() {
        return "Test11{" + "name=" + name + ", age=" + age + '}';
    }

   

    public static void main(String[] args) {
        // Create an instance of Test
        Test11 testInstance = new Test11();
    }
}

