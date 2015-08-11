/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */

var Popup = React.createClass({

    /**
     * Cấu hình cho component
     * @type {Object}
     */
    propTypes: {
        /**
         * setting bao gồm Nội dung thông báo, các buttons sự kiện, cancel button
         * @type {[type]}
         */
        setting : React.PropTypes.object.isRequired
    },

    getDefaultProps: function() {
        return {
            windowHeight:$(window).height(),
            windowWidth :$(window).width(),
            domId: 'popup-' + Math.random(),
            config: {
                title: 'default',
                w: 600,
                autoClose: false,
                timeOut: 2000, //milisecond
                buttons: []               
            },
            timeOutID: null
        };
    },
    
    componentDidMount: function() {
        
    },

    componentWillUnmount: function() {
       
    },
    
    close: function(event){
        if(event) {
            event.preventDefault();
        }
        var node = this.getDOMNode();
        React.unmountComponentAtNode(node);
        $(node).remove();        
        if($.isFunction(this.props.config.closeFn)) {                                  
            this.props.config.closeFn.apply(this);
        }
    },
    
    onClose: function(event){        
        event.preventDefault(); 
        this.close();
    },
    
    onButtonClick: function(event){        
        event.preventDefault();
        this.close();
        
        var index = event.target.getAttribute('data-index');
        var button = this.props.config.buttons[index];
        if(button){
            button.onclick();
        }
        return false;
    },
    
    centerPopup: function(){
        var w = this.props.config.w != undefined ? this.props.config.w : 300,
            h = this.props.config.h != undefined ? this.props.config.h : 300,
            left = 0,
            top = 0;
    
        left = (this.props.windowWidth - w)/2;
        top = (this.props.windowHeight - h)/2 - 50;           
        
        return {
            width: w + 'px',
            height: h == 0 ? 'auto' : h + 'px',
            left: left + 'px',
            top: top + 'px'
        };        
    },
    
    render: function(){ 
        var self = this;
        
        if(this.props.setting){
            this.props.config = this.props.setting;
        }
                
        var divStyle = this.centerPopup();        
        var buttons = this.props.config.buttons.map(function (item, i) {
            var style = 'button pure-button ';
            if(item.cssClass) { 
                style += 'pure-button-primary';
            }
            return (
                <button className={style} id={item.id} data-index={i} onClick={self.onButtonClick}>{item.name}</button> 
            );
        });
        
        if(this.props.config.autoClose){
            var timeOut = 2000;
            if(this.props.config.timeOut){
                timeOut = this.props.config.timeOut;
            }
            self.timeOutID = setTimeout(function(){
                if(self.timeOutID != null) {
                    clearTimeout(self.timeOutID);
                }
                self.close();
            }, timeOut);
        }
        
        return (
            <div className="dialog">
                <div className="popup" id={this.props.alertId} style={divStyle}>                    
                    <div className="header text">
                        <span>{this.props.config.title}</span>
                        <button type="button" className="close" onClick={this.onClose}>×</button>
                    </div>
                    <div className="body text">                        
                        {this.props.children}
                    </div>
                    <div className="footer">
                        {buttons}                        
                        <button className="pure-button pure-button-active button" onClick={this.onClose}>Đóng</button>
                    </div>
                </div>
            </div>
        );        
    }
});

/*
var cbFunction = function(){
    alert('bbb');
};

var test = {};
test.chosen = function(){
    alert('hi');
};

var popupConfig = {
    w: 600,
    title: 'Thông báo',    
    autoClose: false,
    timeOut: 5000, //milisecond
    buttons: [
        {
            id: 'btnCapNhat',
            name: 'Cập nhật',
            cssClass: 'pure-button-primary',
            onclick: function(){
                console.log('Cập nhật');
            }
        },{
            id: 'btnChon',
            name: 'Chọn',
            cssClass: 'pure-button-primary',
            onclick: test.chosen
        }
    ],
    closeFn: function(){ //Hàm được gọi khi nhấn X để close 
        console.log('closeFn');
    }
};

React.render(<Popup setting={popupConfig}><div>123</div></Popup>, document.getElementById('mask-cover'));
*/