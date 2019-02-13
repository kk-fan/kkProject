package com.example.demo1.model;

import com.example.demo1.base.BaseModel;

import java.util.Date;
import javax.persistence.*;

@Table(name = "role")
public class Role extends BaseModel {

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 创建日期
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 修改日期
     */
    @Column(name = "update_date")
    private Date updateDate;

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
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取创建日期
     *
     * @return create_date - 创建日期
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建日期
     *
     * @param createDate 创建日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取修改日期
     *
     * @return update_date - 修改日期
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置修改日期
     *
     * @param updateDate 修改日期
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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
}