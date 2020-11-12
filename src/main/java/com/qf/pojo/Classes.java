package com.qf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classes {
    private int id;
    private String classesName;
    private List<ClassesDetail> list;
    public void method1(ArrayList<String> list){
        System.out.println("11111");
    }
    public void method2(){
        System.out.println("2222");
    }
}
