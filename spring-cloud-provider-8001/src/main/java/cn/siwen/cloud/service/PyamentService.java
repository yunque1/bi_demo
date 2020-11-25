package cn.siwen.cloud.service;

import cn.siwen.cloud.pojo.Payment;

public interface PyamentService {
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
