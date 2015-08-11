/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */

/**
 * Thông báo tự tắt
 * @type {[type]}
 */

var TOAST_TIMEOUT = 3000

var ToastMessage = React.createClass({

    getInitialState: function() {
        return {
        };
    },
    
    /**
     * Kiểm tra kiểu và ràng buộc các properties truyền vào
     * @type {Object}
     */
    propTypes: {
    	message : React.PropTypes.string.isRequired,
    	id : React.PropTypes.string.isRequired,
    	type : React.PropTypes.string.isRequired,
    },

    componentDidMount: function() {
    	var self = this;
        if (self.isMounted()) {
        	// Tự hủy
        	$('#' + this.props.id).css({'left' : (($(window).width() - 320)/2) + "px"}).fadeIn("fast");
        	setTimeout(function() {
        		self.unMout();
        	}, this.props.timeout);
        }
    },

    unMout : function(){
    	React.unmountComponentAtNode(document.getElementById(this.props.id));
    	$('#' + this.props.id).remove();
    },

    render : function(){
    	var styleCtl = {'background' : this.props.type == "error" ? "red" : (this.props.type == "success" ? "#009afd" : "orange")};
    	return(
			<div style={styleCtl}>{this.props.message}</div>
		);
    }
});

/**
 * Hiển thị
 * @param {[type]} message [description]
 * @param {[type]} type    [description]
 * @param {[type]} timeout [description]
 */
ToastMessageFn = function(message, type, timeout){
	var id = _.uniqueId("toast");
	$('body').append("<div class='toast' id='" + id + "'></div>");
	React.render(<ToastMessage message={message} id={id} type={type} timeout={timeout == null ? TOAST_TIMEOUT : timeout} />, document.getElementById(id));
};
/*
ToastMessageFn("hiep", "error", 2000);
*/


