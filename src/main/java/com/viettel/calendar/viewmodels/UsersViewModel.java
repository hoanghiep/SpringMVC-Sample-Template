/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.viewmodels;

import java.util.Date;

/**
 *
 * @author hieptran
 */
public class UsersViewModel {
    
    private Long userId;
    private String userName;
    private String password;
    private String fullname;
    private String email;
    private String mobile;
    private Long status;
    private String userAlias;
    private String homePhone;
    private Date birthday;
    private String code;
    private Long sex;
    private String fax;
    private String identityCode;
    private Date identityCodeDate;
    private String identityCodeOffice;
    private String note;
    private Long orderId;
    private String token;
    private String avatar;
    private Long deptId;
    private String deptName;
    private Long posId;
    private String posName;
    private Date createdAt;
    private Date updatedAt;
    private Long creatorId;
    private Long updatedId;
    private Long isActive;
    private String domainName;

    public UsersViewModel() {
    }

    public UsersViewModel(String userName, String fullname, String email, Long status) {
        this.userName = userName;
        this.fullname = fullname;
        this.email = email;
        this.status = status;
    }

    public UsersViewModel(String userName, String fullname,  String email,String mobile, Long status, Long deptId, Long posId) {
        this.userName = userName;
        this.fullname = fullname;
        this.email = email;
        this.mobile = mobile;
        this.status = status;
        this.deptId = deptId;
        this.posId = posId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getSex() {
        return sex;
    }

    public void setSex(Long sex) {
        this.sex = sex;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode;
    }

    public Date getIdentityCodeDate() {
        return identityCodeDate;
    }

    public void setIdentityCodeDate(Date identityCodeDate) {
        this.identityCodeDate = identityCodeDate;
    }

    public String getIdentityCodeOffice() {
        return identityCodeOffice;
    }

    public void setIdentityCodeOffice(String identityCodeOffice) {
        this.identityCodeOffice = identityCodeOffice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Long getPosId() {
        return posId;
    }

    public void setPosId(Long posId) {
        this.posId = posId;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Long getUpdatedId() {
        return updatedId;
    }

    public void setUpdatedId(Long updatedId) {
        this.updatedId = updatedId;
    }

    public Long getIsActive() {
        return isActive;
    }

    public void setIsActive(Long isActive) {
        this.isActive = isActive;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }
    
    
}
