package cn.edu.cqvie.domain;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Cloneable {

    private Integer age;

    private String name;

    private Study study;

    @Override
    public Object clone() throws CloneNotSupportedException {
        //深拷贝
        Student s = (Student) super.clone();
        s.setStudy((Study) this.study.clone());
        return s;
        //浅拷贝
        //return super.clone();
    }
}
