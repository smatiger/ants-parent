package com.ants.dal.base;

import java.io.Serializable;
import java.util.Date;

/**
* @Description: Do基类
* @author smatiger
* @date 2017年4月24日 下午4:28:51 
*/
public class BaseDo implements Serializable {

    private static final long serialVersionUID = -8734583848228957375L;
    private Long              id;
    /** 创建时间 */
    private Date              createTime;
    /** 更新时间 */
    private Date              updateTime;
    /** 创建人 */
    private String            createPerson;
    /** 更新人 */
    private String            updatePerson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson;
    }
}
