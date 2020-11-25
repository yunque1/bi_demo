package cn.siwen.cloud.service;

import cn.siwen.cloud.dao.PaymentDao;
import cn.siwen.cloud.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class PaymentServiceImpl implements PyamentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int add(Payment payment) {
        return paymentDao.add(payment);
    }

    @Override
    public int delete(Integer id) {
        return paymentDao.delete(id);
    }

    @Override
    public int update(Payment payment) {
        return paymentDao.update(payment);
    }

    @Override
    public Payment select(Integer id) {
        return paymentDao.select(id);
    }
}

