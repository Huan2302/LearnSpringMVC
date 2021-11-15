package com.vinaemter.BAI1.dao;

import com.vinaemter.BAI1.model.student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class studentDao {
    public List<student> findAll(){
        List<student> list = new ArrayList<>();
        list.add(new student(1,"VinaEnter-154 Phạm Như Xương",new Date(),500));
        list.add(new student(2,"VinaEnter-154 Phạm Như Xương",new Date(),500));
        list.add(new student(3,"VinaEnter-154 Phạm Như Xương",new Date(),500));
        list.add(new student(4,"VinaEnter-154 Phạm Như Xương",new Date(),500));
        return list;
    }
}
