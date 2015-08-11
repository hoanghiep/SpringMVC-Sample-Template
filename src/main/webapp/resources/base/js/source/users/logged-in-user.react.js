/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */

/**
 * Người dùng cấu hình thông tin tài khoản của mình
 * Đổi mật khẩu, thay đổi tên, alias
 */
var UserConfigInfo = React.createClass({
    
    mixins: [FormInputEventMixin, ValidatorMixin],
    formDataName : "user",
    
    getInitialState: function() {
        var _user = this.props.user == null ? clone(CurrentUser()) : this.props.user;
        _user["password"] = null;
        _user["newPassword"] = null;
        return {
            user: _user,
            error : '',
            requesting : false
        };
    },
    
    validate : function(){
        return this.basicValidation();
    },
    
    clickUpdateUserHandler : function(event){
        event.preventDefault();
        var self = this;
        if(this.state.requesting){
            return;
        }
        if(!this.validate()){
            return;
        }
        VPostFn('users/updateSelfInfo', this.state.user, function(response){
            if(response.status == 200){
                self.setState({
                    error : '',
                    requesting : false
                });
                ToastMessageFn(response.message, 'success', 2000);
            }
            else{
                self.setState({
                    error : response.message,
                    requesting : false
                });
            }
        });
    },
    
    render : function(){
        var btnMessage = this.state.requesting ? "Đang cập nhập..." : "Cập nhập"; 
        return(
            <div className="pure-form pure-form-aligned">
                <fieldset>
                    <div className="error">
                        <span>{this.state.error}</span>
                    </div>
                    <Clear/>
                    <div className="pure-control-group">
                        <label htmlFor="userAlias">Bí danh</label>
                        <input onChange={this.inputTextOnChangeHandler} name="userAlias" value={this.state.user.userAlias} type="text" placeholder="Bí danh"/>
                    </div>
                    <div className="pure-control-group">
                        <label htmlFor="mobile">Số điện thoại</label>
                        <input onChange={this.inputTextOnChangeHandler} name="mobile" value={this.state.user.mobile} type="text" placeholder="Số điện thoại"/>
                        <RequiredPhoneNumberField keyName="mobile" triggerValue={this.state.user.mobile} errorText={"Số điện thoại không đúng"} callbackErrorFn={this.callbackError}/>
                    </div>
                    <div className="pure-control-group">
                        <label htmlFor="email">Thư điện tử</label>
                        <input onChange={this.inputTextOnChangeHandler} name="email" value={this.state.user.email} type="text" placeholder="Thư điện tử"/>
                        <RequiredEmailField keyName="email" triggerValue={this.state.user.email} errorText={"Thư điện tử không đúng"} callbackErrorFn={this.callbackError}/>
                    </div>
                    <div className="pure-control-group">
                        <label htmlFor="password">Mật khẩu cũ</label>
                        <input onChange={this.inputTextOnChangeHandler} name="password" type="password" placeholder="Mật khẩu cũ"/>
                    </div>
                    <div className="pure-control-group">
                        <label htmlFor="newPassword">Mật mới</label>
                        <input name="newPassword"  onChange={this.inputTextOnChangeHandler} type="password" placeholder="Mật khẩu mới"/>
                        <RequiredMinLengthField minLength={5} keyName="password6" triggerValue={this.state.user.newPassword} errorText={"Mật khẩu lớn hơn 5 ký tự"} callbackErrorFn={this.callbackError}/>
                    </div>
                    <div className="pure-control-group">
                        <label htmlFor="confirmPassword">Xác nhận</label>
                        <input name="confirmPassword" onChange={this.inputTextOnChangeHandler} type="password" placeholder="Xác nhận mật khẩu"/>
                        <RequiredEqualField compareValue={this.state.user.newPassword} keyName="passwordCompare" triggerValue={this.state.user.confirmPassword} errorText={"Hai mật khẩu chưa trùng khớp"} callbackErrorFn={this.callbackError}/>
                    </div>
                    <div className="pure-control-group">
                        <label> </label>
                        <button className="pure-button pure-button-primary" onClick = {this.clickUpdateUserHandler}>{btnMessage}</button>
                    </div>
                </fieldset>
            </div>
        );
    }
});

var UserInfo = React.createClass({
    
    getInitialState: function() {
        return {
            user: this.props.user == null ? {} : this.props.user
        };
    },
    
    changeProfileHandler : function(event){
        var id = event.target.getAttribute('data-id');
        var index = event.target.getAttribute('data-index');
        if(id > 0){
            VPostFn('/changeIdentification', {userId : this.state.user.userId, id : id}, function(response){
                if(response.status == 200){
                    // Tai lai toan bo trang
                    window.location.href = window.baseUrl;
                }
                else{
                    ToastMessageFn(response.message, 'error', 2000);
                }
            });
        }
    },

    getDefaultProps : function(){
        return({
            _csrf : $('meta[name=_csrf]').attr("content"),
            _csrf_header : $('meta[name=_csrf_header]').attr("content")
        });
    },
    
    showPopupChangeProfileHandler : function(event){
        var self = this;
        VPostFn("identification/getAllByUserId", {
            userId : self.state.user.userId
        }, function(response){
            if(response.status == 200){
                if(response.data.length == 0){
                    ToastMessageFn("Người dùng chưa được cấu hình", 'error', 2000);
                    return;
                }
                var identifications = response.data;
                var popupConfig = {
                    w: 400,
                    title: 'Chọn vai trò xử lý hồ sơ',    
                    autoClose: false,
                    timeOut: 5000, //milisecond
                    buttons: [],
                    closeFn: function(){ //Hàm được gọi khi nhấn X để close 

                    }
                };
                var profiles = _.map(identifications, function(d, index){
                    return (
                        <tr>
                            <td className=" pad-top5 pad-bottom5 ">{d.departmentName}</td>
                            <td className=" pad-top5 pad-bottom5 ">{d.roleName}</td>
                            <td className=" width-80 pad-top5 pad-bottom5 ">
                                <a href="#" data-id={d.id} data-index={index} onClick = {self.changeProfileHandler} className="right">Chọn</a>
                            </td>
                        </tr>
                    );
                });
                React.render(
                    (<Popup setting={popupConfig}>
                        <div>   
                            <form method="POST" action={window.logoutUrl}>
                                <input type="hidden" name={"_csrf"} value = {self.props._csrf} />
                                <button className="button-error pure-button" type="submit">Đăng xuất</button>
                            </form>
                        </div>
                        <GrayHr/>
                        <div className="bold">Vai trò làm việc</div>
                        <table className="width100p">
                            {profiles}
                        </table>
                        <GrayHr/>
                        <div className="bold">Thông tin tài khoản</div>
                        <UserConfigInfo user={CurrentUser()}/>
                    </Popup>), 
                    document.getElementById('mask-cover'));
            }
            else{
                ToastMessageFn(response.message, 'error', 2000);
            }
        });
    },
    
    render : function(){
        return(
            <div>
                <div className="no-avatar">
                </div>
                <div className="user-info">
                    <ul className="ul-user-info">
                        <li style={{'fontWeight': 'bold', 'color':'red'}}>
                            {this.state.user.fullname}
                        </li>
                        <li>
                            {this.state.user.positionName}
                        </li>
                        <li>
                            <a href="#" onClick={this.showPopupChangeProfileHandler}>Cài đặt tài khoản</a>
                        </li>
                    </ul>
                </div>
                <Clear/>
            </div>
        );
    }
});

React.render(<UserInfo user={CurrentUser()}/>, document.getElementById('user-profile'));