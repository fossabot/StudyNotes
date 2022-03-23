package com.lnboxue.service;

/**
 * 业务层
 */
public interface LoginService {

    boolean hasMatchAdmin(long adminId,String password);
    String getAdminUsername(long adminId);
}
