/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.beans;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hieptran
 */
@Entity
@Table(name = "USERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "USER_RIGHT")
    private Long userRight;
    @Size(max = 100)
    @Column(name = "USER_NAME")
    private String userName;
    @Size(max = 100)
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "STATUS")
    private Long status;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 30)
    @Column(name = "CELLPHONE")
    private String cellphone;
    @Size(max = 30)
    @Column(name = "TELEPHONE")
    private String telephone;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "FAX")
    private String fax;
    @Column(name = "GENDER")
    private Long gender;
    @Column(name = "DATE_OF_BIRTH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;
    @Column(name = "LAST_CHANGE_PASSWORD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChangePassword;
    @Column(name = "LAST_BLOCK_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastBlockDate;
    @Column(name = "LOGIN_FAILURE_COUNT")
    private Integer loginFailureCount;
    @Column(name = "LAST_LOGIN_FAILURE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginFailure;
    @Size(max = 50)
    @Column(name = "ALIAS_NAME")
    private String aliasName;
    @Size(max = 100)
    @Column(name = "BIRTH_PLACE")
    private String birthPlace;
    @Size(max = 15)
    @Column(name = "IDENTITY_CARD")
    private String identityCard;
    @Size(max = 100)
    @Column(name = "ISSUE_PLACE_IDENT")
    private String issuePlaceIdent;
    @Column(name = "ISSUE_DATE_IDENT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDateIdent;
    @Size(max = 20)
    @Column(name = "PASSPORT_NUMBER")
    private String passportNumber;
    @Size(max = 100)
    @Column(name = "ISSUE_PLACE_PASSPORT")
    private String issuePlacePassport;
    @Column(name = "ISSUE_DATE_PASSPORT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDatePassport;
    @Size(max = 500)
    @Column(name = "FULL_NAME")
    private String fullName;
    @Column(name = "USER_TYPE_ID")
    private Long userTypeId;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 50)
    @Column(name = "STAFF_CODE")
    private String staffCode;
    @Column(name = "MANAGER_ID")
    private Long managerId;
    @Column(name = "LOCATION_ID")
    private Long locationId;
    @Column(name = "PASSWORDCHANGED")
    private Long passwordchanged;
    @Column(name = "LAST_LOGIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @Column(name = "PROFILE_ID")
    private Long profileId;
    @Column(name = "LAST_RESET_PASSWORD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastResetPassword;
    @Size(max = 1000)
    @Column(name = "IP")
    private String ip;
    @Column(name = "DEPT_ID")
    private BigInteger deptId;
    @Size(max = 100)
    @Column(name = "DEPT_LEVEL")
    private String deptLevel;
    @Column(name = "POS_ID")
    private Long posId;
    @Size(max = 300)
    @Column(name = "DEPT_NAME")
    private String deptName;
    @Column(name = "CHECK_VALID_TIME")
    private Long checkValidTime;
    @Column(name = "VALID_FROM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validFrom;
    @Column(name = "VALID_TO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validTo;
    @Column(name = "START_TIME_TO_CHANGE_PASSWORD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTimeToChangePassword;
    @Size(max = 1000)
    @Column(name = "IP_LAN")
    private String ipLan;
    @Column(name = "LAST_UNLOCK")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUnlock;
    @Column(name = "CHECK_IP")
    private Long checkIp;
    @Column(name = "CHECK_IP_LAN")
    private Long checkIpLan;
    @Column(name = "LAST_LOCK")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLock;
    @Column(name = "MINISTRY_JUSTICE_ID")
    private Long ministryJusticeId;
    @Column(name = "DEPT_REPRESENT_ID")
    private BigInteger deptRepresentId;
    @Size(max = 300)
    @Column(name = "DEPT_REPRESENT_NAME")
    private String deptRepresentName;
    @Column(name = "ORDER_ID")
    private Long orderId;
    
    @Column(name="IS_OLD_DATA")
    private Long isOldData;

    public Long getIsOldData() {
        return isOldData;
    }

    public void setIsOldData(Long isOldData) {
        this.isOldData = isOldData;
    }

    public Users() {
    }

    public Users(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserRight() {
        return userRight;
    }

    public void setUserRight(Long userRight) {
        this.userRight = userRight;
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

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Long getGender() {
        return gender;
    }

    public void setGender(Long gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getLastChangePassword() {
        return lastChangePassword;
    }

    public void setLastChangePassword(Date lastChangePassword) {
        this.lastChangePassword = lastChangePassword;
    }

    public Date getLastBlockDate() {
        return lastBlockDate;
    }

    public void setLastBlockDate(Date lastBlockDate) {
        this.lastBlockDate = lastBlockDate;
    }

    public Integer getLoginFailureCount() {
        return loginFailureCount;
    }

    public void setLoginFailureCount(Integer loginFailureCount) {
        this.loginFailureCount = loginFailureCount;
    }

    public Date getLastLoginFailure() {
        return lastLoginFailure;
    }

    public void setLastLoginFailure(Date lastLoginFailure) {
        this.lastLoginFailure = lastLoginFailure;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getIssuePlaceIdent() {
        return issuePlaceIdent;
    }

    public void setIssuePlaceIdent(String issuePlaceIdent) {
        this.issuePlaceIdent = issuePlaceIdent;
    }

    public Date getIssueDateIdent() {
        return issueDateIdent;
    }

    public void setIssueDateIdent(Date issueDateIdent) {
        this.issueDateIdent = issueDateIdent;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getIssuePlacePassport() {
        return issuePlacePassport;
    }

    public void setIssuePlacePassport(String issuePlacePassport) {
        this.issuePlacePassport = issuePlacePassport;
    }

    public Date getIssueDatePassport() {
        return issueDatePassport;
    }

    public void setIssueDatePassport(Date issueDatePassport) {
        this.issueDatePassport = issueDatePassport;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Long userTypeId) {
        this.userTypeId = userTypeId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getPasswordchanged() {
        return passwordchanged;
    }

    public void setPasswordchanged(Long passwordchanged) {
        this.passwordchanged = passwordchanged;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Date getLastResetPassword() {
        return lastResetPassword;
    }

    public void setLastResetPassword(Date lastResetPassword) {
        this.lastResetPassword = lastResetPassword;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public BigInteger getDeptId() {
        return deptId;
    }

    public void setDeptId(BigInteger deptId) {
        this.deptId = deptId;
    }

    public String getDeptLevel() {
        return deptLevel;
    }

    public void setDeptLevel(String deptLevel) {
        this.deptLevel = deptLevel;
    }

    public Long getPosId() {
        return posId;
    }

    public void setPosId(Long posId) {
        this.posId = posId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Long getCheckValidTime() {
        return checkValidTime;
    }

    public void setCheckValidTime(Long checkValidTime) {
        this.checkValidTime = checkValidTime;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public Date getStartTimeToChangePassword() {
        return startTimeToChangePassword;
    }

    public void setStartTimeToChangePassword(Date startTimeToChangePassword) {
        this.startTimeToChangePassword = startTimeToChangePassword;
    }

    public String getIpLan() {
        return ipLan;
    }

    public void setIpLan(String ipLan) {
        this.ipLan = ipLan;
    }

    public Date getLastUnlock() {
        return lastUnlock;
    }

    public void setLastUnlock(Date lastUnlock) {
        this.lastUnlock = lastUnlock;
    }

    public Long getCheckIp() {
        return checkIp;
    }

    public void setCheckIp(Long checkIp) {
        this.checkIp = checkIp;
    }

    public Long getCheckIpLan() {
        return checkIpLan;
    }

    public void setCheckIpLan(Long checkIpLan) {
        this.checkIpLan = checkIpLan;
    }

    public Date getLastLock() {
        return lastLock;
    }

    public void setLastLock(Date lastLock) {
        this.lastLock = lastLock;
    }

    public Long getMinistryJusticeId() {
        return ministryJusticeId;
    }

    public void setMinistryJusticeId(Long ministryJusticeId) {
        this.ministryJusticeId = ministryJusticeId;
    }

    public BigInteger getDeptRepresentId() {
        return deptRepresentId;
    }

    public void setDeptRepresentId(BigInteger deptRepresentId) {
        this.deptRepresentId = deptRepresentId;
    }

    public String getDeptRepresentName() {
        return deptRepresentName;
    }

    public void setDeptRepresentName(String deptRepresentName) {
        this.deptRepresentName = deptRepresentName;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.viettel.calendar.beans.Users[ userId=" + userId + " ]";
    }
    
}
