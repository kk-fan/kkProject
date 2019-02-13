package com.example.demo1.model;

import com.example.demo1.base.BaseModel;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user")
public class User extends BaseModel {

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 性别
     */
    @Column(name = "gender")
    private String gender;

    /**
     * 生日
     */
    @Column(name = "bothirday")
    private Date bothirday;

    /**
     * 身份证件号
     */
    @Column(name = "id_card")
    private String idCard;

    /**
     * 电话号码
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 电子邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 账号是否删除 0 否 1 是
     */
    @Column(name = "is_delete")
    private String isDelete;

    /**
     * 注册时间
     */
    @Column(name = "sign_time")
    private String signTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private String updateTime;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private String roleId;

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取真实姓名
     *
     * @return real_name - 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 获取性别
     *
     * @return gender - 性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置性别
     *
     * @param gender 性别
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * 获取生日
     *
     * @return bothirday - 生日
     */
    public Date getBothirday() {
        return bothirday;
    }

    /**
     * 设置生日
     *
     * @param bothirday 生日
     */
    public void setBothirday(Date bothirday) {
        this.bothirday = bothirday;
    }

    /**
     * 获取身份证件号
     *
     * @return id_card - 身份证件号
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置身份证件号
     *
     * @param idCard 身份证件号
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * 获取电话号码
     *
     * @return phone - 电话号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话号码
     *
     * @param phone 电话号码
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取电子邮箱
     *
     * @return email - 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮箱
     *
     * @param email 电子邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取账号是否删除 0 否 1 是
     *
     * @return is_delete - 账号是否删除 0 否 1 是
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置账号是否删除 0 否 1 是
     *
     * @param isDelete 账号是否删除 0 否 1 是
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    /**
     * 获取注册时间
     *
     * @return sign_time - 注册时间
     */
    public String getSignTime() {
        return signTime;
    }

    /**
     * 设置注册时间
     *
     * @param signTime 注册时间
     */
    public void setSignTime(String signTime) {
        this.signTime = signTime == null ? null : signTime.trim();
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    /**
     * 获取角色id
     *
     * @return role_id - 角色id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     *
     * @param roleId 角色id
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
}