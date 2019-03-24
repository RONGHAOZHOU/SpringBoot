package com.ronghao.chapter13.controller;

import com.ronghao.chapter13.entity.UserEntity;
import com.ronghao.chapter13.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**********************************
 * ============================== 
 * @author Ronghao Zhou          
 * @description
 * @date 10:08 PM 3/16/2018
 * ==============================
 **********************************/
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserJPA userJPA;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<UserEntity> list() {
        return userJPA.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(String name, String password, String address, int age) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setPassword(password);
        userEntity.setAge(age);
        userEntity.setAddress(address);
        userJPA.save(userEntity);
        return "添加成功";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(Long id, String name, String password, String address, int age) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setName(name);
        userEntity.setPassword(password);
        userEntity.setAge(age);
        userEntity.setAddress(address);
        userJPA.save(userEntity);
        return "修改成功";
    }

    @RequestMapping(value = "/delete")
    public String delete(Long id) {
        userJPA.delete(id);
        return "delete successful";
    }

    @RequestMapping(value = "/age")
    public List<UserEntity> age(int minage) {
        return userJPA.nativeQuery(minage);
    }

    @RequestMapping(value = "/deleteByName")
    public String deleteByName(String name) {
        userJPA.deleteByName(name);
        return "delete successul!";
    }

    @RequestMapping(value="/cutPage")
    public List<UserEntity> cutPage(int page) {
        UserEntity user=new UserEntity();
        user.setSize(2);
        user.setPage(page);
        user.setSort("desc");

        Sort.Direction sort_direction=Sort.Direction.ASC.toString().equalsIgnoreCase(user.getSort())?Sort.Direction
                .ASC:Sort.Direction.DESC;
        Sort sort = new Sort(sort_direction, user.getSidx());
        PageRequest pageRequest = new PageRequest(user.getPage() - 1, user.getSize(), sort);
        return userJPA.findAll(pageRequest).getContent();

    }
}
