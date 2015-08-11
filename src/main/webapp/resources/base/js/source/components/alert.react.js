/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */

var Alert = React.createClass({

    getDefaultProps: function() {
        return {
            windowHeight:$(window).height(),
            windowWidth :$(window).width(),
            domId: 'alert-' + Math.random(),
            config: {
                title: 'Title',
                body: 'Content',
                w: 300,
                h: 200,
                buttons: [],
                autoClose: false,
                timeOut: 2000 //milisecond                
            }
        };
    },

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
        top =(this.props.windowHeight - h)/2 - 50;           
        
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
                <div className="alert" id={this.props.domId} style={divStyle}>                    
                    <div className="header text">
                        <span>{this.props.config.title}</span>
                        <button type="button" className="close" onClick={this.close}>×</button>
                    </div>
                    <div className="body text">
                        {this.props.config.body}
                    </div>
                    <div className="footer">
                        {buttons}                        
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

var configAlert = {
    title: 'Thông báo',
    body: 'Văn bản này đã được chuyển xử lý?',    
    w: 200,
    h: 150,
    buttons: [
        {
            id: 'button-ok-alert-1',
            name: 'Đóng',
            onclick: cbFunction,
            cssClass: 'pure-button-primary'
        }
    ],
    closeFn: function(){ //Hàm được gọi khi nhấn close 
        console.log('closeFn');
    },
    autoClose: true,
    timeOut: 3000 //milisecond
};
*/