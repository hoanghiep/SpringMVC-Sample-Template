/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
/**
 * Component chứa toàn bộ các hiển thị về validate dữ liệu
 * Ví dụ như muốn hiển thị email nhập có đúng ko? Trường nào đó có cần nhập ko
 */

/**
 * Hiển thị: trường ko được bỏ trống
 * @type {[type]}
 */
var RequiredField = React.createClass({
    getInitialState: function() {
        return {
            triggerValue : this.props.triggerValue,
            errorText : this.props.errorText
        };
    },
    
    /**
     * Kiểm tra kiểu và ràng buộc các properties truyền vào
     * @type {Object}
     */
    propTypes: {
        triggerValue: React.PropTypes.string.isRequired,
        errorText : React.PropTypes.string.isRequired,
        callbackErrorFn : React.PropTypes.func,
        keyName : React.PropTypes.string.isRequired
    },

    componentWillReceiveProps: function(nextProps) {
        this.setState({
            triggerValue : nextProps.triggerValue
        });
    },

    render : function(){
    	var hasNoError = this.state.triggerValue != null && this.state.triggerValue != "";
		if(this.props.callbackErrorFn){
                    this.props.callbackErrorFn(this.props.keyName, hasNoError);
		}
    	if(hasNoError){
            return(
                <span></span>
                );
        }
        else{
            return(
                <span className="error" style={{'vertical-align' : 'top'}}>{this.state.errorText}</span>
            );
        }
    }
});

/**
 * Kiểm tra số điện thoại
 * @type {[type]}
 */
var RequiredPhoneNumberField = React.createClass({
	
	getInitialState: function() {
        return {
            triggerValue : this.props.triggerValue,
            errorText : this.props.errorText
        };
    },
    
    /**
     * Kiểm tra kiểu và ràng buộc các properties truyền vào
     * @type {Object}
     */
    propTypes: {
        triggerValue: React.PropTypes.number.isRequired,
        errorText : React.PropTypes.string.isRequired,
        callbackErrorFn : React.PropTypes.func,
        keyName : React.PropTypes.string.isRequired
    },

    componentWillReceiveProps: function(nextProps) {
        this.setState({
            triggerValue : nextProps.triggerValue
        });
    },

    render : function(){
    	var reg = new RegExp('^[0-9]+$');
    	// nếu là null là rỗng hoặc là số
    	var hasNoError = this.state.triggerValue == null || 
    						this.state.triggerValue == "" || 
    						(reg.test(this.state.triggerValue) && 
    							this.state.triggerValue.length > 8 && 
    							this.state.triggerValue.length < 11
							);
		if(this.props.callbackErrorFn){
			this.props.callbackErrorFn(this.props.keyName, hasNoError);
		}
    	if(hasNoError){
	    	return(
                    <span></span>
                    );
		}
		else{
                    return(
                        <span className="error" style={{'vertical-align' : 'top'}}>{this.state.errorText}</span>
                    );
		}
    }
});
/**
 * Yêu cầu nhập ngày tháng, kiểm tra ngày tháng có đúng ko bằng pattern truyền vào
 * @type {[type]}
 */
var RequiredDateField = React.createClass({
    getInitialState: function() {
        return {
            triggerValue : this.props.triggerValue,
            errorText : this.props.errorText
        };
    },
    
    /**
     * Kiểm tra kiểu và ràng buộc các properties truyền vào
     * @type {Object}
     */
    propTypes: {
        triggerValue: React.PropTypes.string.isRequired,
        errorText : React.PropTypes.string.isRequired,
        patternDate : React.PropTypes.oneOf(['dd/MM/yyyy', 'MM/dd/yyyy']).isRequired,
        callbackErrorFn : React.PropTypes.func,
        keyName : React.PropTypes.string.isRequired
    },

    componentWillReceiveProps: function(nextProps) {
        this.setState({
            triggerValue : nextProps.triggerValue
        });
    },

    render : function(){
    	var dateRegex = this.props.patternDate == "MM/dd/yyyy" ?  new RegExp('^([0]?[1-9]|[1][0-2])[./-]([0]?[1-9]|[1|2][0-9]|[3][0|1])[./-]([0-9]{4}|[0-9]{2})$')
    															: new RegExp('^([0]?[1-9]|[1|2][0-9]|[3][0|1])[./-]([0]?[1-9]|[1][0-2])[./-]([0-9]{4}|[0-9]{2})$'); 
    	var hasNoError = this.state.triggerValue == null || this.state.triggerValue == "" || dateRegex.test(this.state.triggerValue);
		if(this.props.callbackErrorFn){
			this.props.callbackErrorFn(this.props.keyName, hasNoError);
		}
    	if(hasNoError){
            return(
                <span></span>
                );
            }
            else{
                return(
                    <span className="error" style={{'vertical-align' : 'top'}}>{this.state.errorText}</span>
                );
            }
    }
});

/**
 * Yêu cầu nhập email
 * @type {[type]}
 */
var RequiredEmailField = React.createClass({
    getInitialState: function() {
        return {
            triggerValue : this.props.triggerValue,
            errorText : this.props.errorText
        };
    },
    
    /**
     * Kiểm tra kiểu và ràng buộc các properties truyền vào
     * @type {Object}
     */
    propTypes: {
        triggerValue: React.PropTypes.string.isRequired,
        errorText : React.PropTypes.string.isRequired,
        callbackErrorFn : React.PropTypes.func,
        keyName : React.PropTypes.string.isRequired
    },

    componentWillReceiveProps: function(nextProps) {
        this.setState({
            triggerValue : nextProps.triggerValue
        });
    },

    render : function(){
    	var emailRegex = /^[A-Z0-9_'%=+!`#~$*?^{}&|-]+([\.][A-Z0-9_'%=+!`#~$*?^{}&|-]+)*@[A-Z0-9-]+(\.[A-Z0-9-]+)+$/i;
    	var hasNoError = this.state.triggerValue == null || this.state.triggerValue == "" || emailRegex.test(this.state.triggerValue);
            if(this.props.callbackErrorFn){
                    this.props.callbackErrorFn(this.props.keyName, hasNoError);
            }
    	// nếu là null là rỗng hoặc là số
    	if(hasNoError){
            return(
                <span></span>
                );
            }
            else{
                return(
                    <span className="error" style={{'vertical-align' : 'top'}}>{this.state.errorText}</span>
                );
            }
    }
});

/**
 * Yêu cầu nhập số
 * @type {[type]}
 */
var RequiredNumberField = React.createClass({
    getInitialState: function() {
        return {
            triggerValue : this.props.triggerValue,
            errorText : this.props.errorText
        };
    },
    
    /**
     * Kiểm tra kiểu và ràng buộc các properties truyền vào
     * @type {Object}
     */
    propTypes: {
        triggerValue: React.PropTypes.number.isRequired,
        errorText : React.PropTypes.string.isRequired,
        callbackErrorFn : React.PropTypes.func,
        keyName : React.PropTypes.string.isRequired
    },

    componentWillReceiveProps: function(nextProps) {
        this.setState({
        	triggerValue : nextProps.triggerValue
        });
    },

    render : function(){
    	var reg = new RegExp('^[0-9]+$');
    	// nếu là null là rỗng hoặc là số
    	var hasNoError = this.state.triggerValue == null || this.state.triggerValue == "" || reg.test(this.state.triggerValue);
		if(this.props.callbackErrorFn){
			this.props.callbackErrorFn(this.props.keyName, hasNoError);
		}
    	if(hasNoError){
	    	return(
                    <span></span>
                    );
		}
		else{
                    return(
                        <span className="error" style={{'vertical-align' : 'top'}}>{this.state.errorText}</span>
                    );
		}
    }
});

/**
 * Yêu cầu nhập số trong 1 khoảng nhất định
 * @type {[type]}
 */
var RequiredNumberInRangeField = React.createClass({

    getInitialState: function() {
        return {
            triggerValue : this.props.triggerValue,
            errorText : this.props.errorText
        };
    },
    
    /**
     * Kiểm tra kiểu và ràng buộc các properties truyền vào
     * @type {Object}
     */
    propTypes: {
        triggerValue: React.PropTypes.number.isRequired,
        errorText : React.PropTypes.string.isRequired,
        callbackErrorFn : React.PropTypes.func,
        keyName : React.PropTypes.string.isRequired,
        minValue : React.PropTypes.number.isRequired,
        maxValue : React.PropTypes.number.isRequired
    },

    componentWillReceiveProps: function(nextProps) {
        this.setState({
            triggerValue : nextProps.triggerValue
        });
    },

    render : function(){
        var reg = new RegExp('^[0-9]+$');
        // nếu là null là rỗng hoặc là số
        var hasNoError = this.state.triggerValue == null 
                        || this.state.triggerValue == "" 
                        || ( reg.test(this.state.triggerValue) 
                            && this.state.triggerValue > this.props.minValue 
                            && this.state.triggerValue < this.props.maxValue 
                            );
        if(this.props.callbackErrorFn){
            this.props.callbackErrorFn(this.props.keyName, hasNoError);
        }
        if(hasNoError){
            return(
                <span></span>
            );
        }
        else{
            return(
                <span className="error" style={{'vertical-align' : 'top'}}>{this.state.errorText}</span>
            );
        }
    }
});

/**
 * Yêu cầu nhập dữ liệu có độ dài không lớn hơn độ dài truyền vào
 * @type {[type]}
 */
var RequiredMaxLengthField = React.createClass({
    getInitialState: function() {
        return {
            triggerValue : this.props.triggerValue,
            errorText : this.props.errorText
        };
    },
    
    /**
     * Kiểm tra kiểu và ràng buộc các properties truyền vào
     * @type {Object}
     */
    propTypes: {
        triggerValue: React.PropTypes.string.isRequired,
        errorText : React.PropTypes.string.isRequired,
        callbackErrorFn : React.PropTypes.func,
        keyName : React.PropTypes.string.isRequired,
        maxLength : React.PropTypes.number.isRequired
    },

    componentWillReceiveProps: function(nextProps) {
        this.setState({
            triggerValue : nextProps.triggerValue
        });
    },

    render : function(){
        // nếu là null là rỗng hoặc là số
        var hasNoError = this.state.triggerValue == null || this.state.triggerValue == "" || this.state.triggerValue.length < this.props.maxLength;
        if(this.props.callbackErrorFn){
            this.props.callbackErrorFn(this.props.keyName, hasNoError);
        }
        if(hasNoError){
            return(
                <span></span>
            );
        }
        else{
            return(
                <span className="error" style={{'vertical-align' : 'top'}}>{this.state.errorText}</span>
            );
        }
    }
});

/**
 * Yêu cầu nhập dữ liệu có độ dài lớn hơn độ dài truyền vào
 * @type {[type]}
 */
var RequiredMinLengthField = React.createClass({
    getInitialState: function() {
        return {
            triggerValue : this.props.triggerValue,
            errorText : this.props.errorText
        };
    },
    
    /**
     * Kiểm tra kiểu và ràng buộc các properties truyền vào
     * @type {Object}
     */
    propTypes: {
        triggerValue: React.PropTypes.string.isRequired,
        errorText : React.PropTypes.string.isRequired,
        callbackErrorFn : React.PropTypes.func,
        keyName : React.PropTypes.string.isRequired,
        minLength : React.PropTypes.number.isRequired
    },

    componentWillReceiveProps: function(nextProps) {
        this.setState({
            triggerValue : nextProps.triggerValue
        });
    },

    render : function(){
        // nếu là null là rỗng hoặc là số
        var hasNoError = this.state.triggerValue == null || this.state.triggerValue == "" || this.state.triggerValue.length > this.props.minLength;
        if(this.props.callbackErrorFn){
            this.props.callbackErrorFn(this.props.keyName, hasNoError);
        }
        if(hasNoError){
            return(
                <span></span>
            );
        }
        else{
            return(
                <span className="error" style={{'vertical-align' : 'top'}}>{this.state.errorText}</span>
            );
        }
    }
});

/**
 * Yêu cầu nhập dữ liệu có độ dài lớn hơn độ dài truyền vào
 * @type {[type]}
 */
var RequiredEqualField = React.createClass({
    getInitialState: function() {
        return {
            triggerValue : this.props.triggerValue,
            errorText : this.props.errorText,
            compareValue : this.props.compareValue
        };
    },
    
    /**
     * Kiểm tra kiểu và ràng buộc các properties truyền vào
     * @type {Object}
     */
    propTypes: {
        triggerValue: React.PropTypes.string.isRequired,
        errorText : React.PropTypes.string.isRequired,
        callbackErrorFn : React.PropTypes.func,
        keyName : React.PropTypes.string.isRequired,
        compareValue : React.PropTypes.string.isRequired
    },

    componentWillReceiveProps: function(nextProps) {
        this.setState({
            triggerValue : nextProps.triggerValue,
            compareValue : nextProps.compareValue
        });
    },

    render : function(){
        // nếu là null là rỗng hoặc là số
        var hasNoError = this.state.triggerValue == this.state.compareValue;
        if(this.props.callbackErrorFn){
            this.props.callbackErrorFn(this.props.keyName, hasNoError);
        }
        if(hasNoError){
            return(
                <span></span>
            );
        }
        else{
            return(
                <span className="error" style={{'vertical-align' : 'top'}}>{this.state.errorText}</span>
            );
        }
    }
});