package cn.siwen.cloud.dao;

import cn.siwen.cloud.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PaymentDao {
    //增
    public int add(Payment payment);
    //删
    public int delete(Integer id);
    //改
    public int update(Payment payment);

    //查
    //@Select("select * from payment where id=#{id}")
    public Payment select(Integer id);
}
