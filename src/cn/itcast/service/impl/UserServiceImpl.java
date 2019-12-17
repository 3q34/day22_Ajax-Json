package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.PageBean;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;


import java.util.List;

/**
 * Created by cdx on 2019/11/26.
 * desc:
 */
public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDaoImpl();

    /*
     * @author: cdx
     * @desc: 调用DAO
     * @param null
     * @return:
     * @TO DO:
     * @date: 2019/11/26 14:03
     * @throws:
     */
    @Override
    public List<User> FindAll() {
        return dao.findAll();
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        return dao.findUserByUsernameAndPassword(username, password);
    }

    @Override
    public int add(User user) {
        return dao.add(user);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public int update(User user) {
        return dao.update(user);
    }

    @Override
    public User getUserById(int id) {
        return dao.getUserById(id);
    }

    @Override
    public List<User> queryUserByNameAddrEmail(String name, String address, String email) {
        return dao.queryUserByNameAddrEmail(name, address, email);
    }

    @Override
    public PageBean<User> findUserByPage(String name, String address, String email, int currentPage, int pageSize) {
        return dao.findUserByPage(name,address,email,currentPage,pageSize);
    }

    @Override
    public int getCount() {
        return dao.getCount();
    }
}
