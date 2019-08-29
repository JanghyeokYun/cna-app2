//package com.example.lsis.customersapi;
//
//public class CustomerInfo {
//    private Long id;
//
//    private String name;
//    private int age;
//
//    public CustomerInfo() {
//    }
//
//    public CustomerInfo(Long id, String name, int age) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof CustomerInfo)) return false;
//
//        CustomerInfo that = (CustomerInfo) o;
//
//        if (getAge() != that.getAge()) return false;
//        if (!getId().equals(that.getId())) return false;
//        return getName().equals(that.getName());
//    }
//
//    @Override
//    public int hashCode() {
//        int result = getId().hashCode();
//        result = 31 * result + getName().hashCode();
//        result = 31 * result + getAge();
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        return "CustomerInfo{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
//}
//
//
