package com.vayber.smbms.service.provider;

import com.vayber.smbms.dao.Provider.ProviderMapper;
import com.vayber.smbms.pojo.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService{
    @Autowired
    private ProviderMapper providerMapper;

    public int getProviderCount(String proCode, String proName) throws SQLException {
        return providerMapper.getProviderCount(proCode,proName);
    }


    public List<Provider> getProviderList(String proCode, String proName) throws SQLException {
        return providerMapper.getProviderList(proCode,proName);
    }

    public int addProvider(Provider provider) throws SQLException {
        return providerMapper.addProvider(provider);
    }

    public int deleteProvider(int id) throws SQLException {
        return providerMapper.deleteProvider(id);
    }

    public int modifyProvider(Provider provider) throws SQLException {
        return providerMapper.modifyProvider(provider);
    }

    public Provider getQueryProvider(int id) throws SQLException {
        return providerMapper.getQueryProvider(id);
    }
}
