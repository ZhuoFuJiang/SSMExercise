package com.atguigu.service;

import com.atguigu.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;


    /**
     * 如何添加事务？
     * @Transactional
     * 位置：方法 | 类上
     *
     * 1、只读模式
     * 可以提升查询事务的效率，推荐事务中只有查询代码，使用只读模式
     * 默认：boolean readOnly() default false;
     * 解释：一般情况下，都是通过类添加注解添加事务，类下的所有方法都有事务，查询方法可以通过再次
     * 添加注解，设置为只读模式，提高效率
     *
     * 2、超时时间
     * 默认：永远不超时 -1
     * 设置timeout = 时间 秒数，超过时间，就会回滚事务和释放异常
     *
     * 3、指定异常回滚，和指定异常不回滚
     * 默认情况下，指定发生运行时异常事务才会回滚
     * 我们可以指定Exception异常来控制所有异常都回滚
     * rollbackFor = Exception.class
     * noRollbackFor = 回滚事务范围内，控制某个异常不回滚
     *
     * 4、事务隔离级别
     * isolation属性，推荐设置第二个隔离级别
     *
     * 5、事务传播行为
     * propagation = Propagation.REQUIRED 父方法有事务，我们就加入到父方法的事务，最终是同一个事务
     * propagation = Propagation.REQUIRES_NEW 不管父方法是由有事务，我都新建事务，两个事务或者三个事务
     */
    @Transactional(readOnly = true, timeout = 10, isolation = Isolation.READ_COMMITTED)
    public void changeInfo(){
        studentDao.updateAgeById(100,1);
//        int i = 1 / 0;
        System.out.println("-----------");
        studentDao.updateNameById("test1",1);
    }
}
