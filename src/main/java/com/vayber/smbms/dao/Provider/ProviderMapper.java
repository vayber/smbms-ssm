package com.vayber.smbms.dao.Provider;



import com.vayber.smbms.pojo.Provider;
import org.apache.ibatis.annotations.Param;
import java.sql.SQLException;
import java.util.List;

public interface ProviderMapper {
    //获取供应商总数(根据供应商编码或者供应商名称)
    public int getProviderCount(@Param("proCode")String proCode, @Param("proName")String proName) throws SQLException;

    //获取供应商列表
    public List<Provider> getProviderList(@Param("proCode")String proCode, @Param("proName")String proName) throws SQLException;

    //添加供应商
    public int addProvider( Provider provider) throws  SQLException;

    //删除供应商
    public int deleteProvider( int id) throws  SQLException;

    //修改供应商
    public int modifyProvider(Provider provider) throws SQLException;

    //查询供应商信息
    public Provider getQueryProvider(int id) throws SQLException;


}
