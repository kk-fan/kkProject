package com.example.demo1.model;

import com.example.demo1.base.BaseModel;

import java.util.Date;
import javax.persistence.*;

@Table(name = "menu")
public class Menu extends BaseModel {
    /**
     * 菜单名
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 菜单地址
     */
    @Column(name = "menu_url")
    private String menuUrl;

    /**
     * 修改日期
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建人id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 该角色是否删除 0 否 1 是
     */
    @Column(name = "is_delete")
    private String isDelete;

    /**
     * 是否是父菜单 0 否 1 是
     */
    @Column(name = "is_parent")
    private String isParent;

    /**
     * 上级菜单id
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 排序值
     */
    @Column(name = "sort_no")
    private Integer sortNo;

    /**
     * 获取菜单名
     *
     * @return menu_name - 菜单名
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置菜单名
     *
     * @param menuName 菜单名
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * 获取菜单地址
     *
     * @return menu_url - 菜单地址
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * 设置菜单地址
     *
     * @param menuUrl 菜单地址
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    /**
     * 获取修改日期
     *
     * @return update_time - 修改日期
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改日期
     *
     * @param updateTime 修改日期
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取创建人id
     *
     * @return user_id - 创建人id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置创建人id
     *
     * @param userId 创建人id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取该角色是否删除 0 否 1 是
     *
     * @return is_delete - 该角色是否删除 0 否 1 是
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置该角色是否删除 0 否 1 是
     *
     * @param isDelete 该角色是否删除 0 否 1 是
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    /**
     * 获取是否是父菜单 0 否 1 是
     *
     * @return is_parent - 是否是父菜单 0 否 1 是
     */
    public String getIsParent() {
        return isParent;
    }

    /**
     * 设置是否是父菜单 0 否 1 是
     *
     * @param isParent 是否是父菜单 0 否 1 是
     */
    public void setIsParent(String isParent) {
        this.isParent = isParent == null ? null : isParent.trim();
    }

    /**
     * 获取上级菜单id
     *
     * @return parent_id - 上级菜单id
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置上级菜单id
     *
     * @param parentId 上级菜单id
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 获取排序值
     *
     * @return sort_no - 排序值
     */
    public Integer getSortNo() {
        return sortNo;
    }

    /**
     * 设置排序值
     *
     * @param sortNo 排序值
     */
    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }
}