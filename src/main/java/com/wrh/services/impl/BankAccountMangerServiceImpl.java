package com.wrh.services.impl;

import com.wrh.dto.ResponseDto;
import com.wrh.entity.BankAccount;
import com.wrh.enums.FailedEnum;
import com.wrh.services.BankAccountMangerService;
import com.wrh.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 下午2:52 on 2018/5/27.
 */
@Service
public class BankAccountMangerServiceImpl implements BankAccountMangerService {

    private static SqlSession sqlSession ;

    static {
        sqlSession = MybatisUtil.getSqlSession();
    }
    @Override
    public BankAccount getBankAccountById(Integer id) {
        if (sqlSession == null) {
            sqlSession = MybatisUtil.getSqlSession();
        }
        //模拟根据id来得到BankAccount；
        BankAccount bankAccount = sqlSession.selectOne("mapper.BankAccount.queryById",id);
        return bankAccount;
    }

    @Override
    public ResponseDto updateBankAccount(BankAccount bankAccount) {

        if (sqlSession == null) {
            sqlSession = MybatisUtil.getSqlSession();
        }

        int updateRes = sqlSession.update("mapper.BankAccount.update",bankAccount);
        sqlSession.commit();
        if (updateRes == 1) {
            return ResponseDto.success(null);
        }
        return ResponseDto.fail(FailedEnum.UPDATE_ERROR,"更新错误");
    }
}
